package com.rainhard.discovery.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/discovery-server")
public class DiscoveryDefaultController {

    @GetMapping("/")
    public String getDiscoveryServer(){
        return "This is discovery server spring boot";
    }
}
