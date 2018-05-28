/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.friend;

import guru.bubl.module.model.User;

public interface FriendManagerFactory {
    FriendManager forUser(User user);
}
