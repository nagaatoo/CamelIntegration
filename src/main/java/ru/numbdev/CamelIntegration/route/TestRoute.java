package ru.numbdev.CamelIntegration.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class TestRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
//        from("file:D:\\camel").to("file:D:\\camelout");
    }

}
