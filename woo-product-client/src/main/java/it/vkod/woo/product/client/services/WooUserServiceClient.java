package it.vkod.woo.product.client.services;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import it.vkod.woo.product.client.payloads.auth.response.ApiResponse;
import it.vkod.woo.product.client.payloads.auth.response.JwtAuthResponse;
import it.vkod.woo.product.client.payloads.auth.request.LoginRequest;
import it.vkod.woo.product.client.payloads.auth.request.SignUpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Service
public class WooUserServiceClient {

    @Autowired
    private RestTemplate rest;

    @Autowired
    private EurekaClient discoveryClient;

    private String getAuthServiceUrl() {
        InstanceInfo instance = discoveryClient.getNextServerFromEureka("woo-auth-service", false);
        return instance.getHomePageUrl();
    }

    public String login(final LoginRequest loginRequest) {
        final JwtAuthResponse response = rest.postForObject(getAuthServiceUrl() + "/api/auth/signin", loginRequest, JwtAuthResponse.class);
        return Objects.requireNonNull(response).getAccessToken();
    }

    public boolean register(SignUpRequest signUpRequest) {
        final ApiResponse response = rest.postForObject(getAuthServiceUrl() + "api/auth/signup", signUpRequest, ApiResponse.class);
        return Objects.requireNonNull(response).getSuccess();
    }
}
