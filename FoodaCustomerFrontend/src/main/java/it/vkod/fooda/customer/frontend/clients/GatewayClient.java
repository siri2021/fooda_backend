package it.vkod.fooda.customer.frontend.clients;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;

public class GatewayClient {
    @Autowired
    private static EurekaClient discoveryClient;

    public static String getServerUrl() {
        InstanceInfo instance = discoveryClient.getNextServerFromEureka("fooda-gateway-server", false);
        return instance.getHomePageUrl();
    }

}
