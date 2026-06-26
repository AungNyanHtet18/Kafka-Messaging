package com.dev.anh.kafka.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaProducer {

	private final KafkaTemplate<String, String> kafkaTemplate;

	public void sendMessage(String msg) {
		log.info(String.format("Sending message to Demo Topic:: %s", msg));
		kafkaTemplate.send("demo", msg);
	}
	
}
