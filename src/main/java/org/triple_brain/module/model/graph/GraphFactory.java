/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package org.triple_brain.module.model.graph;

import org.triple_brain.module.model.User;

public interface GraphFactory {
    public UserGraph createForUser(User user);
    public UserGraph loadForUser(User user);
}
