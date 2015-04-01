/*
 * Copyright Vincent Blouin under the Mozilla Public License 1.1
 */

package org.triple_brain.module.model;

public interface UserNameGenerator {
    String generate();
    void setOverride(UserNameGenerator userNameGenerator);
    void reset();
}
