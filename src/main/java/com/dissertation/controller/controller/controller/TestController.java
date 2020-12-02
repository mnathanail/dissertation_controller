package com.dissertation.controller.controller.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping(path = "/test")
    public String test(){
        return "Hello ";
    }

    @PostMapping(path = "/logindsa/12333")
    public String login(){
        System.out.println(123123321);
        return "Hello ";
    }
}
