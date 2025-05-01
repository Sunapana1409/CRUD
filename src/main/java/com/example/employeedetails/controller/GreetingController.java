package com.example.employeedetails.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class GreetingController {

    @GetMapping("/Greeting")
    public String greeting(Map<String, Object> map){
        map.put("Message", "Hello Vivek");
        return "Greeting";
    }
}
