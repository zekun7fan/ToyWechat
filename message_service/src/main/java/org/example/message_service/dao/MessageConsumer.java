package org.example.message_service.dao;


import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.example.commonUtils.dto.Message;
import org.example.commonUtils.entity.Response;
import org.example.message_service.rpc.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.TimeZone;

@Repository
public class MessageConsumer {



    @Autowired
    private ConsumerPool consumerPool;


    public List<Message> retrieveMsg(String uid) {
        KafkaConsumer<String, String> consumer = consumerPool.getRegularConsumer(uid);
        ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(200));
        ArrayList<Message> res = new ArrayList<>();
        for (ConsumerRecord<String, String> record : records) {
            res.add(new Message(record.key(), record.topic(), record.value(), record.offset(), LocalDateTime.ofInstant(Instant.ofEpochMilli(record.timestamp()),
                    TimeZone.getDefault().toZoneId())));
        }
        consumer.commitSync();
        return res;
    }


    /**
     * retrieve message whose offset is from offset and offset + 9 inclusively
     */
    public List<Message> retrieveMsgAfterOffset(String uid, String topic, long offset){
        ArrayList<Message> res = new ArrayList<>();
        KafkaConsumer<String, String> consumer = consumerPool.getSpecificConsumer(uid, topic);
        consumer.seek(new TopicPartition(topic, 0), offset);
        long end = offset + 9;
        int cnt = 20;
        while (cnt > 0) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(200));
            for (ConsumerRecord<String, String> record : records) {
                res.add(new Message(record.key(), record.topic(), record.value(), record.offset(), LocalDateTime.ofInstant(Instant.ofEpochMilli(record.timestamp()),
                        TimeZone.getDefault().toZoneId())));
                if (record.offset() == end) {
                    cnt = -1;
                    break;
                }
            }
            cnt--;
        }
        return res;
    }


    /**
     * retrieve message whose offset is between offset-9 and offset inclusively
     */
    public List<Message> retrieveMsgBeforeOffset(String uid, String topic, long offset){
        ArrayList<Message> res = new ArrayList<>();
        long begin = offset - 9 >= 0 ? offset - 9 : 0;
        long end = offset;
        if (end < 0) {
            return res;
        }
        KafkaConsumer<String, String> consumer = consumerPool.getSpecificConsumer(uid, topic);
        consumer.seek(new TopicPartition(topic, 0), begin);
        boolean run = true;
        while (run) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(200));
            for (ConsumerRecord<String, String> record : records) {
                res.add(new Message(record.key(), record.topic(), record.value(), record.offset(), LocalDateTime.ofInstant(Instant.ofEpochMilli(record.timestamp()),
                        TimeZone.getDefault().toZoneId())));
                if (record.offset() == end) {
                    run = false;
                    break;
                }
            }
        }
        return res;
    }


    public List<Message> retrieveNewestMsg(String uid, String topic) {


        KafkaConsumer<String, String> consumer = consumerPool.getRegularConsumer(uid);
        try {
            long offset = consumer.position(new TopicPartition(topic, 0));
            return retrieveMsgBeforeOffset(uid, topic, offset-1);
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }


    public boolean removeConsumer(String uid) {
        return consumerPool.removeConsumer(uid);
    }

}





