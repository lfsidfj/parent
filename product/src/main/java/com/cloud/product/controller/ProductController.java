package com.cloud.product.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @Value("${server.port}")
    String port;
    @GetMapping("/hello")
    public String hello(){
        return "hello from port " + port;
    }
    @GetMapping("/user")
    public String user() {
        return "user from port " + port;
    }
}
