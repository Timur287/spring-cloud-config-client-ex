package com.example.springcloudconfigclient.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @GetMapping("/")
    public String get(){
        return "eureka client, config server client";
    }
}
