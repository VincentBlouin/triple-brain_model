/*
 * Copyright Vincent Blouin under the Mozilla Public License 1.1
 */

package org.triple_brain.module.model.forget_password;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ForgetPasswordTokenGeneratorTest {

    @Test
    public void hax_30_chars() {
        assertThat(
                ForgetPasswordTokenGenerator.generateToken().length(),
                is(30)
        );
    }

    @Test
    public void token_expiration_date_is_12_hours(){
        DateTime expirationDate = new DateTime(
                ForgetPasswordTokenGenerator.generateTokenExpirationDate()
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
}
