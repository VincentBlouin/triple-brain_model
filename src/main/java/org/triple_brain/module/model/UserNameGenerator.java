/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package org.triple_brain.module.model;

public interface UserNameGenerator {
    String generate();
    void setOverride(UserNameGenerator userNameGenerator);
    void reset();
}
