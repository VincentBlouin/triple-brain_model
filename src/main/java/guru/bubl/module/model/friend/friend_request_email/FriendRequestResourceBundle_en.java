/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.friend.friend_request_email;

import java.util.ListResourceBundle;

public class FriendRequestResourceBundle_en extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        return contents;
    }
    static final Object[][] contents = {
            {"subject", "wants to be your friend"},
            {"body", "Follow this link to accept the friend request"}
    };
}
