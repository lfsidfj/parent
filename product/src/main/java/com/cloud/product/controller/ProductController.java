package com.cloud.product.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    @Value("${server.port}")
    String port;
    @GetMapping("/")
    public String index(){
        return "hello world from port " + port;
    }
}
