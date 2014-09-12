/*
 * Copyright Vincent Blouin under the Mozilla Public License 1.1
 */

package org.triple_brain.module.model.graph;

import org.triple_brain.module.model.User;

public interface GraphFactory {
    public UserGraph createForUser(User user);
    public UserGraph loadForUser(User user);
}
