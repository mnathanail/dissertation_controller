package com.dissertation.controller.controller.service.register;

import com.dissertation.controller.controller.model.profile.Candidate;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Service
public class RegisterService implements IRegister{

    @Qualifier("restTemplateBean")
    private final RestTemplate restTemplate;

    @Override
    public Candidate save(Candidate candidate) {

        return null;
    }
}
