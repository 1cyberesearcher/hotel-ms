package com.example.redical;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class booking {
    @GetMapping("/name")
    public String getData(){
        return "This is from java project and it a jar file";
    }
}
