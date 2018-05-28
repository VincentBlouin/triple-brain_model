/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.friend.friend_request_email;

import com.sendgrid.*;
import guru.bubl.module.model.EmailMindRespect;
import guru.bubl.module.model.User;
import guru.bubl.module.model.forgot_password.email.ForgotPasswordEmail;

import javax.inject.Inject;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class FriendRequestEmailImpl implements FriendRequestEmail {

    @Inject
    EmailMindRespect emailMindRespect;

    public Mail sendToUserFromUser(User destinationUser, User requestUser, String confirmURL) {
        Locale emailLocale = destinationUser.getLocaleForBundle();
        ResourceBundle messages = PropertyResourceBundle.getBundle(
                "guru.bubl.module.model.friend.friend_request_email.FriendRequestResourceBundle",
                emailLocale
        );
        String subject = requestUser.username() + " " +messages.getString("subject");
        String msgBody =  messages.getString("body") + " " + confirmURL;
        Mail mail;
        Email to = new Email(
                destinationUser.email()
        );
        Content content = new Content(
                "text/plain",
                msgBody
        );
        mail = new Mail(EmailMindRespect.FROM, subject, to, content);
        emailMindRespect.send(mail);
        return mail;
    }
}
