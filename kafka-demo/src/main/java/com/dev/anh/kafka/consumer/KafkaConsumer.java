package com.dev.anh.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.dev.anh.kafka.payload.Student;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafkaConsumer {

	//@KafkaListener(topics = "demo", groupId = "myGroup")
	public void consumeMsg(String msg) {
		log.info(String.format("Consuming the message from demo topic:: %s", msg));
	}
	
	@KafkaListener(topics = "demo", groupId = "myGroup")
	public void consumeMsgAsJson(Student student) {
		log.info(String.format("Consuming the message from demo topic:: %s", student.toString()));
	}
	
}