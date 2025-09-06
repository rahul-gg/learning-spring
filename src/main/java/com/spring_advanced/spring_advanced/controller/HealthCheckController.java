package com.spring_advanced.spring_advanced.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

    @GetMapping("/health-check")
    public String isHealthy(){
        return "OK";
    }
}
