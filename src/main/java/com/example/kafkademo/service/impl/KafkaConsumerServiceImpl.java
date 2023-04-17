package com.example.kafkademo.service.impl;

import com.example.kafkademo.service.KafkaConsumerService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerServiceImpl implements KafkaConsumerService {

    @Override
//    @KafkaListener(topics = "goat", groupId = "group_id")
    public void consumer(Object data) {
        System.out.println(data);
    }
}
