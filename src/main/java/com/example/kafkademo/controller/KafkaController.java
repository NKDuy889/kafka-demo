package com.example.kafkademo.controller;

import com.example.kafkademo.dto.KafkaDTO;
import com.example.kafkademo.service.KafkaProducerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("pub")
    public ResponseEntity<Object> send(@RequestBody Object obj) {
        kafkaService.sendMessage(obj);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
