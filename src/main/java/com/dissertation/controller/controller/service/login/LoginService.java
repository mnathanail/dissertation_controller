package com.dissertation.controller.controller.service.login;

import com.dissertation.controller.controller.model.login.Login;
import com.dissertation.controller.controller.model.login.ResponseLogin;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;

@RequiredArgsConstructor
@Service
public class LoginService implements ILogin{

    @Qualifier("restTemplateBean")
    private final RestTemplate restTemplate;

    private static final String url = "http://localhost:8081";

    @Override
    public ResponseLogin login(Login credentials) {

        /*ResponseLogin response = this.webClient
                .post()
                .uri("/api/candidate/login", credentials)
                .retrieve()
                .bodyToMono(ResponseLogin.class)
                .block();
        System.out.println(response);*/
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Login> entity = new HttpEntity<>(credentials, headers);

       // ResponseEntity<ResponseLogin> a = this.restTemplate.exchange("/api/candidate/login", HttpMethod.POST, entity, ResponseLogin.class);
        ResponseLogin response = this.restTemplate.postForObject("/api/candidate/login",  entity, ResponseLogin.class);
        return response;
    }
}
