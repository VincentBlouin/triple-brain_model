/*
 * Copyright Vincent Blouin under the Mozilla Public License 1.1
 */

package org.triple_brain.module.model.forget_password;

import java.util.Date;

public class UserForgetPasswordToken {
    private String token;
    private Date expirationDate;

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
}
