package com.jsg.jjstudygroup.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    @Id
    @GeneratedValue
    private Long mno;

    private String id;

    private String pw;

    private String email;

    private String authority;

    private char sex;

    private String name;

    private LocalDateTime regdate;
}
