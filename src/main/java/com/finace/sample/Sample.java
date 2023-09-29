package com.finace.sample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Sample {

    @GetMapping({"/","/index"})
    public String index(){

        return "hello,world";
    }
}
