/*
 * Copyright Vincent Blouin under the Mozilla Public License 1.1
 */

package org.triple_brain.module.model.forget_password;

import java.util.Date;

public class UserForgetPasswordToken {
    private String token;
    private Date expirationDate;

    public static UserForgetPasswordToken empty(){
        return new UserForgetPasswordToken();
    }

    public static UserForgetPasswordToken generate(){
        return UserForgetPasswordToken.withTokenAndExpirationDate(
                ForgetPasswordTokenGenerator.generateToken(),
                ForgetPasswordTokenGenerator.generateTokenExpirationDate()
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

    public String getResetPasswordToken(){
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
}
