package it.vkod.services;

import it.vkod.models.payload.ApiResponse;
import it.vkod.models.payload.JwtAuthResponse;
import it.vkod.models.payload.LoginRequest;
import it.vkod.models.payload.SignUpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Service
public class WooUserService {

    @Autowired
    private RestTemplate rest;

    public boolean login(final LoginRequest loginRequest) {
        final JwtAuthResponse response = rest.postForObject("http://localhost:9092/api/auth/signin", loginRequest, JwtAuthResponse.class);
        return !Objects.requireNonNull(response).getAccessToken().isBlank();
    }

    public boolean register(SignUpRequest signUpRequest) {
        final ApiResponse response = rest.postForObject("http://localhost:9092/api/auth/signup", signUpRequest, ApiResponse.class);
        return Objects.requireNonNull(response).getSuccess();
    }
}
