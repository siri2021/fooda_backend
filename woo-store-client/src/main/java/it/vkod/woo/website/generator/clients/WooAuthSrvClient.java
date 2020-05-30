package it.vkod.woo.website.generator.clients;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import it.vkod.woo.website.generator.pojo.auth.req.LoginRequest;
import it.vkod.woo.website.generator.pojo.auth.req.SignUpRequest;
import it.vkod.woo.website.generator.pojo.auth.res.ApiResponse;
import it.vkod.woo.website.generator.pojo.auth.res.JwtAuthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Service
public class WooAuthSrvClient {

    @Autowired
    private RestTemplate rest;

    @Autowired
    private EurekaClient discoveryClient;

    private String getAuthServiceUrl() {
        InstanceInfo instance = discoveryClient.getNextServerFromEureka("woo-auth-service", false);
        return instance.getHomePageUrl();
    }

    public boolean login(final LoginRequest loginRequest) {
        final JwtAuthResponse response = rest.postForObject(getAuthServiceUrl() + "/api/auth/signin", loginRequest, JwtAuthResponse.class);
        return !Objects.requireNonNull(response).getAccessToken().isBlank();
    }

    public boolean register(SignUpRequest signUpRequest) {
        final ApiResponse response = rest.postForObject(getAuthServiceUrl() + "api/auth/signup", signUpRequest, ApiResponse.class);
        return Objects.requireNonNull(response).getSuccess();
    }
}
