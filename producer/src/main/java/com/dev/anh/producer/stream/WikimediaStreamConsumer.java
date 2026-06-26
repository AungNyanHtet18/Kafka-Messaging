package com.dev.anh.producer.stream;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import com.dev.anh.producer.producer.WikimediaProducer;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class WikimediaStreamConsumer {

	private final WebClient webClient;
	private final WikimediaProducer wikimediaProducer;
	
	public WikimediaStreamConsumer(WebClient.Builder webClientBuilder, WikimediaProducer wikimediaProducer) {
		this.webClient = webClientBuilder
							.baseUrl("https://stream.wikimedia.org/v2")
							.build();
		
		this.wikimediaProducer = wikimediaProducer;
	}
	
	public void consumeStreamAndPublish() {
		webClient.get()
				 .uri("/stream/recentchange")
				 .retrieve()
				 .bodyToFlux(String.class)
				 .subscribe(wikimediaProducer::sendMessage);
	}
}
