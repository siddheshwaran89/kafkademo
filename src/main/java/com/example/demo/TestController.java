package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	@Autowired
	private KafkaProducer kafkaProducer;
	@GetMapping("/greeting")
    public String greeting() {
        
		kafkaProducer.sendMessage("Hello, Worldddddd!");
		
		return "welcome";
    }
}
