package org.triple_brain.module.model;

/*
* Copyright Mozilla Public License 1.1
*/
public class EmptyGraphTransaction implements GraphTransaction{

    @Override
    public Object before() {
        return null;
    }

    @Override
    public void after(Object state) {}
}
