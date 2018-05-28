/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.friend;

import guru.bubl.module.model.User;

import java.net.URI;
import java.util.List;
import java.util.Map;

public interface FriendManager {
    String add(User otherUser);
    FriendManager confirm(User otherUser);
    Boolean confirmWithToken(User otherUser, String confirmToken);
    Map<URI, FriendPojo> list();
    FriendStatus getStatusWithUser(User otherUser);
}
