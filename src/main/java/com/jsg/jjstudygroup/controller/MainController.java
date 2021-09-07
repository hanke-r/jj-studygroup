package com.jsg.jjstudygroup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    /**
     * main method
     *
     * @return index.html
     */
    @GetMapping("/")
    public String main(){
        return "index";
    }
}
