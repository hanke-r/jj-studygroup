package com.jsg.jjstudygroup.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ConfirmToken {

    @Id
    @GeneratedValue
    private Long  tokenNo;

    private String email;

    private String authKey;

    private LocalDateTime regDate;

}
