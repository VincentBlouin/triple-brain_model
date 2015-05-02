/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package org.triple_brain.module.model.forgot_password.email;

import org.triple_brain.module.model.User;

import javax.mail.Message;

public interface ForgotPasswordEmail {
    Message send(User user, String resetUrl);
}
