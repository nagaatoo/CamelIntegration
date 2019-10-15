package ru.numbdev.CamelIntegration.route;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer extends RouteBuilder {

    private final CamelContext context;

    public MessageConsumer(CamelContext context) {
        this.context = context;
    }

    @Override
    public void configure() throws Exception {
        from("kafka:topic1?brokers=localhost:9092"
                + "&maxPollRecords=5000"
                + "&consumersCount=2"
                + "&seekTo=beginning"
                + "&groupId=g1")
//                .routeId("FromKafka")
                .to("file:D:\\camelout");
    }
}
