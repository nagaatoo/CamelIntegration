package ru.numbdev.CamelIntegration;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConsumerListener {


    @KafkaListener(topics = "topic1", groupId = "g1")
    public void listen(Object message) {
        System.out.println("--------->" + message);
    }
}
