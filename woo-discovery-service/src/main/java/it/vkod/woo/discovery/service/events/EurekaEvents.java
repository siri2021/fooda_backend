package it.vkod.woo.discovery.service.events;

import com.netflix.appinfo.InstanceInfo;
import org.springframework.cloud.netflix.eureka.server.event.*;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EurekaEvents {

    @EventListener
    public void listen(EurekaInstanceCanceledEvent eurekaInstanceCanceledEvent) {

        final String appName = eurekaInstanceCanceledEvent.getAppName();
        final String serverId = eurekaInstanceCanceledEvent.getServerId();
        System.out.println("Eureka Instance is cancelled. Application: " + appName + ", ServerId: " + serverId);
    }

    @EventListener
    public void listen(EurekaInstanceRegisteredEvent eurekaInstanceRegisteredEvent) {
        InstanceInfo instanceInfo = eurekaInstanceRegisteredEvent.getInstanceInfo();
        if (instanceInfo.getAppName().toLowerCase().contains("woo-product")
                && instanceInfo.getStatus() == InstanceInfo.InstanceStatus.UP
                && !eurekaInstanceRegisteredEvent.isReplication()
        ) {
            System.out.println("Product Service " + instanceInfo.getAppName() + " is online!");
        }

    }
}
