/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.forgot_password.email;

import guru.bubl.module.model.User;

import javax.mail.Message;

public interface ForgotPasswordEmail {
    Message send(User user, String resetUrl);
}
