package org.triple_brain.module.model.graph;

import org.triple_brain.module.model.User;

/*
* Copyright Mozilla Public License 1.1
*/
public interface GraphFactory {
    public UserGraph createForUser(User user);
    public UserGraph loadForUser(User user);
}
