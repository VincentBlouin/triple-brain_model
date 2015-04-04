/*
 * Copyright Vincent Blouin under the Mozilla Public License 1.1
 */

package org.triple_brain.module.model.forget_password;

import org.apache.commons.lang.RandomStringUtils;

public class ForgetPasswordTokenGenerator {

    private static final Integer NUMBER_OF_CHARS = 30;

    public static String generate(){
        return RandomStringUtils.randomAlphanumeric(
                NUMBER_OF_CHARS
        );
    }

}
