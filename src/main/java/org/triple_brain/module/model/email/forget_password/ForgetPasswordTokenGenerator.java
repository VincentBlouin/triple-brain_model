/*
 * Copyright Vincent Blouin under the Mozilla Public License 1.1
 */

package org.triple_brain.module.model.email.forget_password;

import javax.inject.Inject;
import javax.inject.Named;

public class ForgetPasswordTokenGenerator {

    @Inject
    @Named("forgetPasswordSecret")
    String secret;

    public void generate(){

    }

}
