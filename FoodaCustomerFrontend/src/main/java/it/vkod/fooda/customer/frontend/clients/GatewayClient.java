package it.vkod.fooda.customer.frontend.clients;

import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;

public class GatewayClient {

    @Autowired
    private static EurekaClient discoveryClient;

    public static String getServerUrl() {
        return "http://localhost:8080";
//        InstanceInfo instance = discoveryClient.getNextServerFromEureka("fooda-gateway-server", false);
//        return instance.getHomePageUrl();
    }

}
