package com.cloud.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RibbonService {
    @Autowired
    RestTemplate restTemplate;
    @HystrixCommand(fallbackMethod = "helloServiceFailure")
    public String getHelloContent() {
        return restTemplate.getForObject("http://SERVICE-HELLOWORLD/hello",String.class);
    }
    public String helloServiceFailure() {
        System.out.println("hello world service is not available !");
        return "hello world service is not available !";
    }
    @HystrixCommand(fallbackMethod = "userServiceFailure")
    public String getUserContent() {
        return restTemplate.getForObject("http://SERVICE-HELLOWORLD/user",String.class);
    }
    public String userServiceFailure() {
        System.out.println("hello world service is not available !");
        return "hello world service is not available !";
    }
}
