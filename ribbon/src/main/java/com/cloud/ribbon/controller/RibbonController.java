package com.cloud.ribbon.controller;

import com.cloud.ribbon.service.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RibbonController {
    @Autowired
    RibbonService ribbonService;
    @GetMapping("/")
    public String getHelloContent() {
        return ribbonService.getHelloContent();
    }
    @GetMapping("/user")
    public String getUserContent() {
        return ribbonService.getUserContent();
    }
}
