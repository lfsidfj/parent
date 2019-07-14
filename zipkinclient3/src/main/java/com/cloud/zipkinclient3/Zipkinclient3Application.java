package com.cloud.zipkinclient3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class Zipkinclient3Application {

    public static void main(String[] args) {
        SpringApplication.run(Zipkinclient3Application.class, args);
    }
    private static final Logger LOG = Logger.getLogger(Zipkinclient3Application.class.getName());


    @Autowired
    private RestTemplate restTemplate;

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @RequestMapping("/cc")
    public String cc(){
        LOG.log(Level.INFO, "cc");
        return restTemplate.getForObject("http://SERVICE-ZIPKIN2/dd", String.class);
    }
}
