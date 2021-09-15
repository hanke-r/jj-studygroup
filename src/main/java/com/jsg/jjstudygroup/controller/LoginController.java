package com.jsg.jjstudygroup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    /**
     * login method
     *
     * @return login
     */
    @GetMapping("/login")
    public String login(){
        return "login";
    }


    /**
     * register method
     *
     * @return
     */
    @GetMapping("/register")
    public String register() {
        return "register";
    }
}
