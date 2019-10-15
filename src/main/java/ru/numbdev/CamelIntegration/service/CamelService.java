package ru.numbdev.CamelIntegration.service;

import org.apache.camel.CamelContext;
import org.apache.camel.component.kafka.KafkaComponent;
import org.springframework.stereotype.Service;
import ru.numbdev.CamelIntegration.route.MessageConsumer;
import ru.numbdev.CamelIntegration.route.MessageProducer;
import ru.numbdev.CamelIntegration.route.TestRoute;

import javax.annotation.PostConstruct;

@Service
public class CamelService {

    private final CamelContext context;
    private final TestRoute testRoute;
    private final MessageProducer messageProducer;
    private final MessageConsumer messageConsumer;

    public CamelService(CamelContext context, TestRoute testRoute, MessageProducer messageProducer, MessageConsumer messageConsumer) {
        this.context = context;
        this.testRoute = testRoute;
        this.messageProducer = messageProducer;
        this.messageConsumer = messageConsumer;
    }

    @PostConstruct
    private void initRoute() throws Exception {
//        context.addRoutes(testRoute);
//        context.start();
//        Thread.sleep(60000);
//        context.stop();

        configureKafkaWithContext();
        context.addRoutes(messageProducer);
        context.addRoutes(messageConsumer);
        context.start();
        Thread.sleep(60000);
//        context.stop();
    }

    private void configureKafkaWithContext() {
        KafkaComponent kafka = new KafkaComponent();
        kafka.setBrokers("localhost:9092");
        context.addComponent("kafka", kafka);
    }
}
