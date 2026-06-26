package com.dev.anh.kafka.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.anh.kafka.payload.Student;
import com.dev.anh.kafka.producer.KafkaJsonProducer;
import com.dev.anh.kafka.producer.KafkaProducer;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/message")
@RequiredArgsConstructor
public class MessageController {

	private final KafkaProducer kafkaProducer;
    private final KafkaJsonProducer kafkaJsonProducer;
	
	@PostMapping
	public ResponseEntity<String> sendMessage(
			       @RequestBody String message) {
		 kafkaProducer.sendMessage(message);
		 return ResponseEntity.ok("Message queue successfully.");
	}
	
	@PostMapping("/json")
	public ResponseEntity<String> sendJsonMessage(
			       @RequestBody Student student) {
		 kafkaJsonProducer.sendMessages(student);
		 return ResponseEntity.ok("Message queue successfully as Json.");
	}	
}
