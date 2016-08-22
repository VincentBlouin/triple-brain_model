/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.forgot_password.email;

import com.sendgrid.Mail;
import guru.bubl.module.model.User;

public interface ForgotPasswordEmail {
    Mail send(User user, String resetUrl);
}
