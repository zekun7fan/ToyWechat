package org.example.message_service.service;


import org.example.message_service.dao.MessageConsumer;
import org.example.message_service.dao.MessageProducer;
import org.example.commonUtils.dto.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageConsumer consumer;

    @Autowired
    private MessageProducer producer;

    public boolean sendMsg(Message msg){
        return producer.sendMsg(msg);
    }

    public List<Message> retrieveMsg(String uid) {
        return consumer.retrieveMsg(uid);
    }

    public List<Message> retrieveMsgBeforeOffset(String uid, String topic, long offset){
        return consumer.retrieveMsgBeforeOffset(uid, topic, offset);
    }



    public List<Message> retrieveMsgAfterOffset(String uid, String topic, long offset){
        return consumer.retrieveMsgAfterOffset(uid, topic, offset);
    }


    public List<Message> retrieveNewestMsg(String uid, String topic){
        return consumer.retrieveNewestMsg(uid, topic);
    }

    public boolean removeConsumer(String uid) {
        return consumer.removeConsumer(uid);
    }


}
