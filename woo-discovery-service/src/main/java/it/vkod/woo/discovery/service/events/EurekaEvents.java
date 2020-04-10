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
        if (
                instanceInfo.getAppName().toLowerCase().contains("woo-product")
                        && instanceInfo.getStatus() == InstanceInfo.InstanceStatus.UP
                        && !eurekaInstanceRegisteredEvent.isReplication()
        ) {
            System.out.println("New instance of " + instanceInfo.getAppName() + " is registered!");
        } else {
            System.out.println(instanceInfo.getAppName() + " is not necessary to be registered.. Thus, skipped.");
        }

    }

    @EventListener
    public void listen(EurekaInstanceRenewedEvent eurekaInstanceRenewedEvent) {
        final String appName = eurekaInstanceRenewedEvent.getAppName();
        final String serverId = eurekaInstanceRenewedEvent.getServerId();
        System.out.println("Eureka Instance is renewed. Application: " + appName + ", ServerId: " + serverId);
    }

    @EventListener
    public void listen(EurekaRegistryAvailableEvent eurekaRegistryAvailableEvent) {
    System.out.println("EurekaRegistryAvailableEvent");
    }

    @EventListener
    public void listen(EurekaServerStartedEvent eurekaServerStartedEvent) {
    System.out.println("EurekaServerStartedEvent");
    }
}
