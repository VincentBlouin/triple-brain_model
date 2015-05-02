/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package org.triple_brain.module.model.forgot_password.email;

import org.triple_brain.module.model.User;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Locale;
import java.util.Properties;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class ForgotPasswordEmailImpl implements ForgotPasswordEmail {
    private static final String from = "no-reply@bubl.guru";
    private static final Session session = Session.getDefaultInstance(
            new Properties(),
            null
    );
    public Message send(User user, String resetUrl){
        Locale emailLocale = user.getPreferredLocales().contains(
                Locale.FRENCH
        ) ? Locale.FRENCH : Locale.ENGLISH;
        ResourceBundle messages = PropertyResourceBundle.getBundle(
                "org.triple_brain.module.model.forgot_password.email.ForgotPasswordResourceBundle",
                emailLocale
        );
        String msgBody = messages.getString("body");
        msgBody += " " + resetUrl;
        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(from));
            msg.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(user.email()));
            msg.setSubject(
                    messages.getString("subject")
            );
            msg.setText(msgBody);
            Transport.send(msg);
            return msg;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}