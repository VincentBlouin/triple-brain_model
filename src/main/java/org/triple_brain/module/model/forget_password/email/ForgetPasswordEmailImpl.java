/*
 * Copyright Vincent Blouin under the Mozilla Public License 1.1
 */

package org.triple_brain.module.model.forget_password.email;

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

public class ForgetPasswordEmailImpl implements ForgetPasswordEmail{
    private static final String from = "no-reply@bubl.guru";
    private static final Session session = Session.getDefaultInstance(
            new Properties(),
            null
    );
    public Message send(User user){
        Locale emailLocale = user.getPreferredLocales().contains(
                Locale.FRENCH
        ) ? Locale.FRENCH : Locale.ENGLISH;
        ResourceBundle messages = PropertyResourceBundle.getBundle(
                "org.triple_brain.module.model.forget_password.email.ForgetPasswordResourceBundle",
                emailLocale
        );
        String msgBody = messages.getString("body");
        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(from));
            msg.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(user.email()));
            msg.setSubject("bubl.guru password reset");
            msg.setText(msgBody);
            Transport.send(msg);
            return msg;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
