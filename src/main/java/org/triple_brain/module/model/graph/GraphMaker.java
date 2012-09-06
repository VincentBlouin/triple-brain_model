package org.triple_brain.module.model.graph;

import org.triple_brain.module.model.User;

/*
* Copyright Mozilla Public License 1.1
*/
public interface GraphMaker {
    public UserGraph createForUser(User user);
}
