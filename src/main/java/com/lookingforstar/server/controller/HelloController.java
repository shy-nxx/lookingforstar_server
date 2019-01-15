package com.lookingforstar.server.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@RestController
public class HelloController {

    @RequestMapping("/")
    public String hello() {

        return "Hello, Spring Boot!";
    }
}

