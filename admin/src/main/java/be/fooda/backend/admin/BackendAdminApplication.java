package be.fooda.backend.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableAdminServer
public class BackendAdminApplication {
	public static void main(String[] args) {
	      SpringApplication.run(BackendAdminApplication.class, args);
      }
}
