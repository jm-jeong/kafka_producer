package com.fastcampus.kafka_producer.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class KafkaProducer {
	private final KafkaTemplate<String, String> kafkaTemplate;

	public KafkaProducer(@Autowired KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	@GetMapping("/send")
	public void send(@RequestParam String text) {
		kafkaTemplate.send("test", text);
	}
}
