package com.example.kafkademo.service;

import com.example.kafkademo.dto.UserDTO;

import java.util.List;

public interface KafkaProducerService {
    void sendMessage(UserDTO dtoJson);

    void sendMessageMultipleValue(List<UserDTO> dtoJson);
}
