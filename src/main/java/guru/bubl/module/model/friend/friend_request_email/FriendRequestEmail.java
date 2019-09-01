/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.friend.friend_request_email;

import com.sendgrid.helpers.mail.Mail;
import guru.bubl.module.model.User;

public interface FriendRequestEmail {
    Mail sendToUserFromUser(
            User destinationUser,
            User requestUser,
            String confirmURL
    );
}
