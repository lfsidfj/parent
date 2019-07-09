package com.cloud.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class ConfigclientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigclientApplication.class, args);
    }
    @Value("${hello}")
    String hello;
    @RequestMapping(value = "/hello")
    public String hello(){
        return hello;
    }
}
