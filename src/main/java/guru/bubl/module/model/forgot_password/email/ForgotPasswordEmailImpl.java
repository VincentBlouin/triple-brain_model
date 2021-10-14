/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.forgot_password.email;

import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import guru.bubl.module.model.EmailMindRespect;
import guru.bubl.module.model.User;

import javax.inject.Inject;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class ForgotPasswordEmailImpl implements ForgotPasswordEmail {

    @Inject
    EmailMindRespect emailMindRespect;

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
        System.out.println("sending forgot password email using from " + EmailMindRespect.FROM);
        mail = new Mail(EmailMindRespect.FROM, subject, to, content);
        emailMindRespect.send(mail);
        return mail;
    }
}
