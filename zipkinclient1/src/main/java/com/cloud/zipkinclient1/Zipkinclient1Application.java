package com.cloud.zipkinclient1;

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
public class Zipkinclient1Application {

    public static void main(String[] args) {
        SpringApplication.run(Zipkinclient1Application.class, args);
    }
    private static final Logger LOG = Logger.getLogger(Zipkinclient1Application.class.getName());


    @Autowired
    private RestTemplate restTemplate;

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @RequestMapping("/aa")
    public String aa(){
        LOG.log(Level.INFO, "aa");
        return restTemplate.getForObject("http://SERVICE-ZIPKIN2/bb", String.class);
    }
    @RequestMapping("/ee")
    public String ee(){
        LOG.log(Level.INFO, "ee");
        return "i'm service-hi11111111111";
    }
}
