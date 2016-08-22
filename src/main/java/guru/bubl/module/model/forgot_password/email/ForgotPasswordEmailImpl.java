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
            "no-reply@bubl.guru"
    );

    @Inject
    SendGrid sendgrid;

//    private static final Session session = Session.getDefaultInstance(
//            new Properties(),
//            null
//    );

    public Mail send(User user, String resetUrl) {
        Locale emailLocale = user.getPreferredLocales().contains(
                Locale.FRENCH
        ) ? Locale.FRENCH : Locale.ENGLISH;
        ResourceBundle messages = PropertyResourceBundle.getBundle(
                "guru.bubl.module.model.forgot_password.email.ForgotPasswordResourceBundle",
                emailLocale
        );
        String msgBody = messages.getString("body");
        msgBody += " " + resetUrl;
        try {
//            Message msg = new MimeMessage(session);
//            msg.setFrom(new InternetAddress(from));
//            msg.addRecipient(Message.RecipientType.TO,
//                    new InternetAddress(user.email()));
//            msg.setSubject(
//                    messages.getString("subject")
//            );
//            msg.setText(msgBody);
//            Transport.send(msg);

            String subject = messages.getString("subject");
            Email to = new Email(
                    user.email()
            );
            Content content = new Content(
                    "text/plain",
                    msgBody
            );
            Mail mail = new Mail(from, subject, to, content);

            Request request = new Request();
            request.method = Method.POST;
            request.endpoint = "mail/send";
            request.body = mail.build();
            sendgrid.api(request);
            return mail;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}