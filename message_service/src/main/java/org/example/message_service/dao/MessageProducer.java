package org.example.message_service.dao;


import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import org.example.commonUtils.dto.Message;
import org.example.message_service.exception.CustomizeErrorCode;
import org.example.commonUtils.exception.CustomException;
import org.springframework.stereotype.Repository;

import java.util.Properties;

@Repository
public class MessageProducer {

    private Properties properties = new Properties(){
        {
            this.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
            this.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
            this.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        }
    };

    private KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);


    public boolean sendMsg(Message msg){

//        Properties properties = new Properties();
//        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
//        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);

        producer.send(new ProducerRecord<>(msg.getTopic(), msg.getUid(), msg.getMsg()), new Callback() {
            @Override
            public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                if (e != null) {
                    throw new CustomException(CustomizeErrorCode.MSG_SENT_EXCEPTION);
                }else{
                    // to do
                }
            }
        });

//        producer.close();
        return true;
    }
}
