package com.jsg.jjstudygroup.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) throws Exception{
        web.ignoring().antMatchers("/css/**", "/js/**", "/images/**", "/fonts/**");
    }


    /**
     * (1) 경로 허용
     * (2) default 로그인 페이지 지정
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // (1) login, register, main 페이지는 누구나 접근가능 - 추후 main 페이지도 로그인한 사용자만 이용 가능
        http.authorizeRequests()
                .antMatchers("/login", "/", "/register").permitAll()
                .anyRequest().authenticated();

        http.formLogin()
                .loginPage("/login");

        http.logout()
                .logoutSuccessUrl("/");



    }
}
