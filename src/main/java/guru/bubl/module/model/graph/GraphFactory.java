/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.graph;

import guru.bubl.module.model.User;

public interface GraphFactory {
    public UserGraph createForUser(User user);
    public UserGraph loadForUser(User user);
}
