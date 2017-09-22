/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.forgot_password.email;

import com.sendgrid.*;
import guru.bubl.module.model.User;

import javax.inject.Inject;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class ForgotPasswordEmailImpl implements ForgotPasswordEmail {
    private static final Email from = new Email(
            "no-reply@mindrespect.com"
    );

    @Inject
    SendGrid sendgrid;

    public Mail send(User user, String resetUrl) {
        Locale emailLocale = user.getLocaleForBundle();
        ResourceBundle messages = PropertyResourceBundle.getBundle(
                "guru.bubl.module.model.forgot_password.email.ForgotPasswordResourceBundle",
                emailLocale
        );
        String msgBody = messages.getString("body");
        msgBody += " " + resetUrl;
        Mail mail;
        String subject = messages.getString("subject");
        Email to = new Email(
                user.email()
        );
        Content content = new Content(
                "text/plain",
                msgBody
        );
        mail = new Mail(from, subject, to, content);
        try {
            Request request = new Request();
            request.method = Method.POST;
            request.endpoint = "mail/send";
            request.body = mail.build();
            sendgrid.api(request);
        } catch (Exception e) {
            /*
            *  continue
            *  SendGrid throws a non relevant error.
            *  Update SendGrid version in maven when available
            */

        }
        return mail;
    }
}