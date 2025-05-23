
package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaProducer {

    private static final String TOPIC = "mytest";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        //CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send(TOPIC,2,"docg-1" ,message);
        CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send(TOPIC ,message);
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                System.out.println("Message sent successfully: " + message +
                                   " with offset: " + result.getRecordMetadata().offset());
                System.out.println("meda: " + result.getRecordMetadata());
                System.out.println("tostring: " + result.toString());
            } else {
                System.err.println("Message failed to send: " + message);
                ex.printStackTrace();
            }
        });
    }
}
