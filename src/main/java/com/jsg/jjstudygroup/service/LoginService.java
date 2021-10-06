package com.jsg.jjstudygroup.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Random;

@RequiredArgsConstructor
@Service
public class LoginService {

    private final JavaMailSender javaMailSender;

    public void mailSend(String email, String lang) {
        ConfigurableApplicationContext ctx = new GenericApplicationContext(); // Context 객체 생성
        ConfigurableEnvironment env = ctx.getEnvironment();
        MutablePropertySources propertySources = env.getPropertySources();

        try{
            if(lang.equals("en")){
                propertySources.addLast(new ResourcePropertySource("classpath:messages/message_en.properties"));
            } else {
                propertySources.addLast(new ResourcePropertySource("classpath:messages/message.properties"));
            }
            String title = new String(env.getProperty("spring.mail.title").getBytes("ISO-8859-1"), "UTF-8");
            String content = new String(env.getProperty("spring.mail.content").getBytes("ISO-8859-1"), "UTF-8");

            // Email 인증 난수 생성
            Random random = new Random();
            String key = "";
            for(int i = 0 ; i < 3 ; i++){
                int index = random.nextInt(25)+65;
                key += (char) index;
            }
            int numIndex = random.nextInt(9999)+1000;
            key += numIndex;

            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setTo(email);
            simpleMailMessage.setSubject(title);
            simpleMailMessage.setText(content + key);

            javaMailSender.send(simpleMailMessage);
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
