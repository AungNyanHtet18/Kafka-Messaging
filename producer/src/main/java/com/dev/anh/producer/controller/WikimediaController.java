package com.dev.anh.producer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.anh.producer.stream.WikimediaStreamConsumer;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/wikimedia")
@RequiredArgsConstructor
public class WikimediaController {
    
	private final WikimediaStreamConsumer streamConsumer;
	
	@GetMapping
	public void startPublishing() {
		streamConsumer.consumeStreamAndPublish();
	}
	
}
