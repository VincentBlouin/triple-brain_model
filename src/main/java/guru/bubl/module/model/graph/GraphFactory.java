/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.graph;

import guru.bubl.module.model.User;

public interface GraphFactory {
    UserGraph createForUser(User user);
    UserGraph loadForUser(User user);
}
