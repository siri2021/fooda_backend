package be.fooda.backend.gateway.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class FoodaGatewayApp {

	public static void main(String[] args) {
		SpringApplication.run(be.fooda.backend.gateway.server.FoodaGatewayApp.class, args);
	}

}
