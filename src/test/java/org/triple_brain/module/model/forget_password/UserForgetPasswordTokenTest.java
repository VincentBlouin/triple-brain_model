/*
 * Copyright Vincent Blouin under the Mozilla Public License 1.1
 */

package org.triple_brain.module.model.forget_password;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class UserForgetPasswordTokenTest {

    @Test
    public void token_has_30_chars() {
        UserForgetPasswordToken userForgetPasswordToken = UserForgetPasswordToken.generate();
        assertThat(
                userForgetPasswordToken.getResetPasswordToken().length(),
                is(30)
        );
    }

    @Test
    public void token_expiration_date_is_12_hours(){
        UserForgetPasswordToken userForgetPasswordToken = UserForgetPasswordToken.generate();
        DateTime expirationDate = new DateTime(
                userForgetPasswordToken.getResetPasswordExpirationDate()
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
        UserForgetPasswordToken userForgetPasswordToken = UserForgetPasswordToken.generate();
        assertFalse(
                userForgetPasswordToken.isExpired()
        );
        userForgetPasswordToken.setResetPasswordExpirationDate(
                DateTime.now().minusHours(1).toDate()
        );
        assertTrue(
                userForgetPasswordToken.isExpired()
        );
    }

    @Test
    public void can_test_if_has_token(){
        UserForgetPasswordToken userForgetPasswordToken = UserForgetPasswordToken.generate();
        assertFalse(
                userForgetPasswordToken.hasToken("token")
        );
        userForgetPasswordToken.setResetPasswordToken(
                "token"
        );
        assertTrue(
                userForgetPasswordToken.hasToken("token")
        );
    }
}
