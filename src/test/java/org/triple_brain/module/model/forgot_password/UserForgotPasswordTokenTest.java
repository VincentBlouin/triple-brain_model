/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package org.triple_brain.module.model.forgot_password;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class UserForgotPasswordTokenTest {

    @Test
    public void token_has_30_chars() {
        UserForgotPasswordToken userForgotPasswordToken = UserForgotPasswordToken.generate();
        assertThat(
                userForgotPasswordToken.getToken().length(),
                is(30)
        );
    }

    @Test
    public void token_expiration_date_is_12_hours(){
        UserForgotPasswordToken userForgotPasswordToken = UserForgotPasswordToken.generate();
        DateTime expirationDate = new DateTime(
                userForgotPasswordToken.getResetPasswordExpirationDate()
        );
        Duration duration = new Duration(
                new DateTime(),
                expirationDate.hourOfDay().roundCeilingCopy()
        );
        assertThat(
                duration.getStandardHours(),
                is(new Integer(12).longValue())
        );
    }

    @Test
    public void can_be_expired(){
        UserForgotPasswordToken userForgotPasswordToken = UserForgotPasswordToken.generate();
        assertFalse(
                userForgotPasswordToken.isExpired()
        );
        userForgotPasswordToken.setResetPasswordExpirationDate(
                DateTime.now().minusHours(1).toDate()
        );
        assertTrue(
                userForgotPasswordToken.isExpired()
        );
    }

    @Test
    public void can_test_if_has_token(){
        UserForgotPasswordToken userForgotPasswordToken = UserForgotPasswordToken.generate();
        assertFalse(
                userForgotPasswordToken.hasToken("token")
        );
        userForgotPasswordToken.setResetPasswordToken(
                "token"
        );
        assertTrue(
                userForgotPasswordToken.hasToken("token")
        );
    }
}
