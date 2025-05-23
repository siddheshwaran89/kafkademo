package com.example.demo;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

	@KafkaListener(topicPartitions = @TopicPartition(topic = "mytest", partitions = {"0","1","2"}), groupId = "docg")
    public void consume(String message, Acknowledgment acknowledgment) {
        System.out.println("Message received: " + message);
        // Acknowledge the message after successful processing
        acknowledgment.acknowledge();
    }
}
