package fooda.resto.pos.frontend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FoodaRestoPosFrontendApp {

    public static void main(String[] args) {
        SpringApplication.run(FoodaRestoPosFrontendApp.class, args);
    }

}
