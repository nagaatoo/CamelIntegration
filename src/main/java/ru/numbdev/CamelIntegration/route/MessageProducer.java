package ru.numbdev.CamelIntegration.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.kafka.KafkaComponent;
import org.apache.camel.component.kafka.KafkaConstants;
import org.springframework.stereotype.Component;

@Component
public class MessageProducer extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("direct:kafkaStart")
//                .routeId("DirectToKafka")
                .to("kafka:topic1");

//        // Topic can be set in header as well.
//
//        from("direct:kafkaStartNoTopic").routeId("kafkaStartNoTopic")
//                .to("kafka:dummy");
//
//        // Use custom partitioner based on the key.
//
//        from("direct:kafkaStartWithPartitioner").routeId("kafkaStartWithPartitioner")
//                .to("kafka:topic1?partitioner=ru.numbdev.CamelIntegration.config.StringPartitioner");


        // Takes input from the command line.

        from("file:D:\\camel")
                .setHeader(KafkaConstants.PARTITION_KEY, simple("0"))
//                .setHeader(KafkaConstants.KEY, simple("1"))
                .to("direct:kafkaStart");
    }
}
