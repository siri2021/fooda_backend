package be.fooda.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// @EnableEurekaClient
// @EnableAdminServer
public class BackendAdminApplication {
	public static void main(String[] args) {
	      SpringApplication.run(BackendAdminApplication.class, args);
      }
}
