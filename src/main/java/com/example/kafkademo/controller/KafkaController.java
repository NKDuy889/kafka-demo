package com.example.kafkademo.controller;

import com.example.kafkademo.dto.UserDTO;
import com.example.kafkademo.service.KafkaProducerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("kafka")
public class KafkaController {

    private final KafkaProducerService kafkaService;

    public KafkaController(KafkaProducerService kafkaService) {
        this.kafkaService = kafkaService;
    }

    @GetMapping("")
    public ResponseEntity<Object> get() {
        return new ResponseEntity<>("Nice to miss you", HttpStatus.OK);
    }

    @PostMapping("pub-one")
    public ResponseEntity<Object> send(@RequestBody UserDTO dto) {
        try {
            kafkaService.sendMessage(dto);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("pub-many")
    public ResponseEntity<Object> sendMany(@RequestBody List<UserDTO> dto) {
        try {
            kafkaService.sendMessageMultipleValue(dto);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
