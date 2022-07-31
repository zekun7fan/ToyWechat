package org.example.message_service.dao;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.example.message_service.rpc.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.listener.ConsumerAwareBatchErrorHandler;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.*;



@Component
public class ConsumerPool {

    private final int capacity = 1000;

    private final int maxRegularRecords = 100;

    private final int maxSpecificRecords = 10;


    @Autowired
    private UserController userController;


    private final Map<String, KafkaConsumer<String, String>> regularMap = new LinkedHashMap<>();

    private final Map<String, KafkaConsumer<String, String>> specificMap = new LinkedHashMap<>();


    public KafkaConsumer<String, String> getRegularConsumer(String key){
        if (regularMap.containsKey(key)){
            KafkaConsumer<String, String> consumer = regularMap.get(key);
            regularMap.remove(key);
            regularMap.put(key, consumer);
            return consumer;
        }
        if (regularMap.size() >= capacity){
            String victimKey = regularMap.entrySet().iterator().next().getKey();
            regularMap.remove(victimKey);
        }
        KafkaConsumer<String, String> consumer = createRegularKafkaConsumer(key);
        regularMap.put(key, consumer);
        return consumer;
    }


    public KafkaConsumer<String, String> getSpecificConsumer(String key, String topic){
        if (specificMap.containsKey(key)){
            KafkaConsumer<String, String> consumer = specificMap.get(key);
            specificMap.remove(key);
            specificMap.put(key, consumer);
            consumer.assign(Collections.singletonList(new TopicPartition(topic, 0)));
            while (consumer.assignment().isEmpty()) {
                consumer.poll(Duration.ofMillis(200));
            }
            return consumer;
        }
        if (specificMap.size() >= capacity){
            String victimKey = specificMap.entrySet().iterator().next().getKey();
            specificMap.remove(victimKey);
        }
        KafkaConsumer<String, String> consumer = createSpecificKafkaConsumer(key, topic);
        specificMap.put(key, consumer);
        return consumer;
    }


    private KafkaConsumer<String, String> createRegularKafkaConsumer(String uid){
        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, uid);
        properties.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, maxRegularRecords);
        properties.put(ConsumerConfig.FETCH_MAX_WAIT_MS_CONFIG, 100);
        properties.put(ConsumerConfig.FETCH_MIN_BYTES_CONFIG, 1);
        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(properties);
        List<String> userTopicList = userController.getUserTopicList(uid).getData();
        consumer.subscribe(userTopicList);
        return consumer;
    }



    private KafkaConsumer<String, String> createSpecificKafkaConsumer(String uid, String topic){
        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);

        properties.put(ConsumerConfig.GROUP_ID_CONFIG, uid);
        properties.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, maxSpecificRecords);
        properties.put(ConsumerConfig.FETCH_MAX_WAIT_MS_CONFIG, 100);
        properties.put(ConsumerConfig.FETCH_MIN_BYTES_CONFIG, 1);
        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(properties);
        consumer.assign(Collections.singletonList(new TopicPartition(topic, 0)));
        while (consumer.assignment().isEmpty()) {
            consumer.poll(Duration.ofMillis(200));
        }
        return consumer;
    }


    public boolean removeConsumer(String uid) {
        boolean res1 = true;
        boolean res2 = true;
        if (regularMap.containsKey(uid)) {
            res1 = regularMap.remove(uid) != null;
        }
        if (specificMap.containsKey(uid)) {
            res2 = specificMap.remove(uid) != null;
        }
        return res1 && res2;
    }








}
