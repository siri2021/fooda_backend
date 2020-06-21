package it.vkod.fooda.discovery.server.events;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceCanceledEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRegisteredEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class EurekaEvents {

    @Autowired
    private RestTemplate rest;

    @EventListener
    public void listen(EurekaInstanceCanceledEvent canceledEvent) {
        final String appName = canceledEvent.getAppName();
        final String serverId = canceledEvent.getServerId();
        log.info("Eureka Instance is cancelled. Application: " + appName + ", ServerId: " + serverId);
    }

    @EventListener
    public void listen(EurekaInstanceRegisteredEvent registeredEvent) {
//        InstanceInfo instanceInfo = registeredEvent.getInstanceInfo();
//        if (instanceInfo.getAppName().toLowerCase().contains("woocommerce") && instanceInfo.getStatus() == InstanceInfo.InstanceStatus.UP && !registeredEvent.isReplication()) {
//            log.info("Product Service " + instanceInfo.getAppName() + " is loading..");
//            final String endpoint = instanceInfo.getHomePageUrl() + "api/woocommerce/products/store";
//            log.info("Endpoint: " + endpoint);
//            final FoodaStore store = rest.getForObject(endpoint, FoodaStore.class);
//            rest.postForObject("http://localhost:8080/api/store/add", store, FoodaStore.class);
//            log.info("Store from " + instanceInfo.getAppName() + " is registered to store server..");
//            log.info("Product Service " + instanceInfo.getAppName() + " is online!");
//        }

    }
}
