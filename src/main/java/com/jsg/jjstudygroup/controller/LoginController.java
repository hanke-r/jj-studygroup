package com.jsg.jjstudygroup.controller;

import com.jsg.jjstudygroup.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;


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

    @PostMapping("/email")
    public void emailAuth(@RequestParam("email") String email) throws Exception{
//        loginService.sendSimpleMessage(email.get("email"));

    }
}
