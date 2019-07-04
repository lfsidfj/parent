package com.cloud.feign.service;

import org.springframework.stereotype.Component;

@Component
public class HelloWorldServiceFailure implements HelloWorldService {
    @Override
    public String sayHello() {
        System.out.println("hello world service is not available !");
        return "hello world service is not available !";
    }

    @Override
    public String sayUser() {
        System.out.println("user service is not available !");
        return "user service is not available !";
    }
}
