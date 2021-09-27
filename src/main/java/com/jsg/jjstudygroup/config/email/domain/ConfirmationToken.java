package com.jsg.jjstudygroup.config.email.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ConfirmationToken {

    private static final int EMAIL_TOKEN_EXPIRATION_TIME_VALUE = 5;

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(length = 36)
    private String tokenId;

    @Column
    private Date expirationDate;

    @Column
    private boolean expired;

    @Column
    private Long mno;

    @CreatedDate
    @Column(updatable = false)
    private Date createDate;

    @LastModifiedDate
    private Date lastModifiedDate;

    /**
     * Email 인증 토큰 생성
     * @param mno
     * @return
     */
    public static ConfirmationToken createEmailConfirmationToken(Long mno) throws Exception{
        ConfirmationToken confirmationToken = new ConfirmationToken();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MINUTE, EMAIL_TOKEN_EXPIRATION_TIME_VALUE);
        String plusDate = sdf.format(cal.getTime());

        confirmationToken.expirationDate = sdf.parse(plusDate);
        confirmationToken.mno = mno;
        confirmationToken.expired = false;

        return confirmationToken;
    }

    /**
     * 사용된 토큰 만료
     */
    public void useToken(){
        expired = true;
    }


}
