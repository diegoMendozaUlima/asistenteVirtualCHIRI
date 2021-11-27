package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;

public class HomeResource {
    
    @GetMapping("/")
    public String home(){
        return("<h1>Welcome</h1>");
    }

    @GetMapping("/user")
    public String user(){
        return("<h1>Welcome user</h1>");
    }

    @GetMapping("/admin")
    public String admin(){
        return("<h1>Welcome admin</h1>");
    }
}
