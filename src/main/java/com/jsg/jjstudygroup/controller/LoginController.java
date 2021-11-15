package com.jsg.jjstudygroup.controller;

import com.jsg.jjstudygroup.dto.LoginVO;
import com.jsg.jjstudygroup.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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


    @PostMapping("/login")
    public String postLogin(Model model, LoginVO loginVO){

        System.out.println("id = " + loginVO.getId());

        model.addAttribute("rs", "login success!");

        return "jsonView";
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


    @PostMapping("/certifiedEmail")
    public String certifiedEmail(@RequestParam("email") String email, @RequestParam("lang") String lang){

        loginService.mailSend(email, lang);

        return "jsonView";
    }

}
