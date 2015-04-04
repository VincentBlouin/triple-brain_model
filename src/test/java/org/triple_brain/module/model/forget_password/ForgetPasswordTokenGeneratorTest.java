/*
 * Copyright Vincent Blouin under the Mozilla Public License 1.1
 */

package org.triple_brain.module.model.forget_password;

import org.junit.Test;
import org.triple_brain.module.model.forget_password.ForgetPasswordTokenGenerator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ForgetPasswordTokenGeneratorTest {

    @Test
    public void hax_30_chars() {
        assertThat(
                ForgetPasswordTokenGenerator.generate().length(),
                is(30)
        );
    }
}
