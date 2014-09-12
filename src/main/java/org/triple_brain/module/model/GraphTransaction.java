/*
 * Copyright Vincent Blouin under the Mozilla Public License 1.1
 */

package org.triple_brain.module.model;

public interface GraphTransaction {
    public Object before();
    public void after(Object state);
}

