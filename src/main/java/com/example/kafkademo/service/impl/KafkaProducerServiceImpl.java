package com.example.kafkademo.service.impl;

import com.example.kafkademo.constant.TopicKafka;
import com.example.kafkademo.dto.UserDTO;
import com.example.kafkademo.service.KafkaProducerService;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KafkaProducerServiceImpl implements KafkaProducerService {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public KafkaProducerServiceImpl(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void sendMessage(UserDTO dtoJson) {
        if (dtoJson == null) {
            System.out.println("Exception with dto sendMessage");
            return;
        }
        kafkaTemplate.send("goat", TopicKafka.PUB_ONE , dtoJson);
    }

    @Override
    public void sendMessageMultipleValue(List<UserDTO> dtoJson) {
        if (dtoJson == null) {
            System.out.println("Exception with dto");
            return;
        }
        kafkaTemplate.send("goat", TopicKafka.PUB_MANY, dtoJson);
    }
}
