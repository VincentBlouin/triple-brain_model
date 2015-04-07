/*
 * Copyright Vincent Blouin under the Mozilla Public License 1.1
 */

package org.triple_brain.module.model.forget_password;

import org.apache.commons.lang.RandomStringUtils;
import org.joda.time.DateTime;

import java.util.Date;

public class UserForgetPasswordToken {

    private String token;
    private Date expirationDate;

    public static UserForgetPasswordToken empty(){
        return new UserForgetPasswordToken();
    }

    public static UserForgetPasswordToken generate(){
        return UserForgetPasswordToken.withTokenAndExpirationDate(
                generateToken(),
                generateTokenExpirationDate()
        );
    }

    public static UserForgetPasswordToken withTokenAndExpirationDate(String token, Date expirationDate){
        UserForgetPasswordToken userForgetPasswordToken = new UserForgetPasswordToken();
        userForgetPasswordToken.setResetPasswordToken(token);
        userForgetPasswordToken.setResetPasswordExpirationDate(expirationDate);
        return userForgetPasswordToken;
    }

    public UserForgetPasswordToken setResetPasswordToken(String token){
        this.token = token;
        return this;
    }

    public String getToken(){
        return token;
    }

    public Date getResetPasswordExpirationDate(){
        return expirationDate;
    }

    public UserForgetPasswordToken setResetPasswordExpirationDate(Date expirationDate){
        this.expirationDate = expirationDate;
        return this;
    }

    public Boolean isEmpty(){
        return token == null;
    }

    public Boolean isExpired(){
        return new Date().after(
                expirationDate
        );
    }

    public Boolean hasToken(String token){
        return token.equals(this.token);
    }

    private static final Integer TOKEN_NUMBER_OF_CHARS = 30;

    private static String generateToken(){
        return RandomStringUtils.randomAlphanumeric(
                TOKEN_NUMBER_OF_CHARS
        );
    }

    private static Date generateTokenExpirationDate(){
        return new DateTime().plusHours(12).toDate();
    }
}
