/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.friend.friend_confirmation_email;

import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import guru.bubl.module.model.EmailMindRespect;
import guru.bubl.module.model.User;

import javax.inject.Inject;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class FriendConfirmationEmailImpl implements FriendConfirmationEmail {

    @Inject
    EmailMindRespect emailMindRespect;

    public Mail sendForUserToUser(User destinationUser, User requestUser, String destinationUserUrl) {
        Locale emailLocale = destinationUser.getLocaleForBundle();
        ResourceBundle messages = PropertyResourceBundle.getBundle(
                "guru.bubl.module.model.friend.friend_confirmation_email.FriendConfirmationResourceBundle",
                emailLocale
        );
        String subject = destinationUser.username() + " " + messages.getString("subject");
        String msgBody = messages.getString("body");
        msgBody+= " " + destinationUserUrl;
        Mail mail;
        Email to = new Email(
                requestUser.email()
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
