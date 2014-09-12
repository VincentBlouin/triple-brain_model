/*
 * Copyright Vincent Blouin under the Mozilla Public License 1.1
 */

package org.triple_brain.module.model;

public class EmptyGraphTransaction implements GraphTransaction{

    @Override
    public Object before() {
        return null;
    }

    @Override
    public void after(Object state) {}
}
