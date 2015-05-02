/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package org.triple_brain.module.model;

public interface GraphTransaction {
    public Object before();
    public void after(Object state);
}

