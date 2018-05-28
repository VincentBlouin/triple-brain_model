/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.friend.friend_confirmation_email;

import java.util.ListResourceBundle;

public class FriendConfirmationResourceBundle_en extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return contents;
    }
    static final Object[][] contents = {
            {"subject", "has accepted your friend request"},
            {"body", "You can now see more bubbles at this link"}
    };
}
