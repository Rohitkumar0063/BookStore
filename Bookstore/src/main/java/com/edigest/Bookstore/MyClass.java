package com.edigest.Bookstore;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyClass {


    @GetMapping("abc")
    public String say(){
        return "Hello";
    }
}
