//package com.example.kafkademo.utils;
//
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Component;
//
//@Component
//public class KafkaUtil {
//
//    private final KafkaTemplate<String, Object> kafkaTemplate;
//
//    public KafkaUtil(KafkaTemplate<String, Object> kafkaTemplate) {
//        this.kafkaTemplate = kafkaTemplate;
//    }
//
//    public void sendMessage(String topicName, Object msg) {
//        kafkaTemplate.send(topicName, msg);
//    }
//}
