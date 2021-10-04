package com.jsg.jjstudygroup.service;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LoginService {

    private final JavaMailSender javaMailSender;

    public void mailSend(String email) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(email);
        simpleMailMessage.setSubject("title");
        simpleMailMessage.setText("Text Mail Sender");

        javaMailSender.send(simpleMailMessage);
    }

}
