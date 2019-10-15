package ru.numbdev.CamelIntegration;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.numbdev.CamelIntegration.route.TestRoute;

@SpringBootApplication
public class CamelIntegrationApplication {


	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext run = SpringApplication.run(CamelIntegrationApplication.class, args);

	}

}
