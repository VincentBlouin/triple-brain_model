/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.friend.friend_confirmation_email;

import com.sendgrid.Mail;
import guru.bubl.module.model.User;

public interface FriendConfirmationEmail {
    Mail sendForUserToUser(
            User destinationUser,
            User requestUser,
            String destinationUserUrl
    );
}
