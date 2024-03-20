package com.udemy.studentproject.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


//@Controller
//@ResponseBody instead of this two annotations we can use 

@RestController

public class HelloWorldController {


    //Http GET request
    //http://localhost:8080/hello-world

    @GetMapping("/hello-world")
    public String HelloWorld( ) {
        return "Hello World";
    }
}
