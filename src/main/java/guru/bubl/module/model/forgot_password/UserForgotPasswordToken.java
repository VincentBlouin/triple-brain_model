/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.forgot_password;

import org.apache.commons.lang.RandomStringUtils;
import org.joda.time.DateTime;

import java.util.Date;

public class UserForgotPasswordToken {

    private String token;
    private Date expirationDate;

    public static UserForgotPasswordToken empty(){
        return new UserForgotPasswordToken();
    }

    public static UserForgotPasswordToken generate(){
        return UserForgotPasswordToken.withTokenAndExpirationDate(
                generateToken(),
                generateTokenExpirationDate()
        );
    }

    public static UserForgotPasswordToken withTokenAndExpirationDate(String token, Date expirationDate){
        UserForgotPasswordToken userForgotPasswordToken = new UserForgotPasswordToken();
        userForgotPasswordToken.setResetPasswordToken(token);
        userForgotPasswordToken.setResetPasswordExpirationDate(expirationDate);
        return userForgotPasswordToken;
    }

    public UserForgotPasswordToken setResetPasswordToken(String token){
        this.token = token;
        return this;
    }

    public String getToken(){
        return token;
    }

    public Date getResetPasswordExpirationDate(){
        return expirationDate;
    }

    public UserForgotPasswordToken setResetPasswordExpirationDate(Date expirationDate){
        this.expirationDate = new Date(expirationDate.getTime());
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
