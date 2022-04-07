package com.example.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceService {

    @GetMapping("/api/public")
    public String publicResource(){
        return "PUBLIC-RESOURCE";
    }

    @GetMapping("/api/private")
    public String privateResource(){
        Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication);
        return "PRIVATE-RESOURCE";
    }


}
