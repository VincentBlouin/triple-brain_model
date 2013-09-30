package org.triple_brain.module.model;

/*
* Copyright Mozilla Public License 1.1
*/
public interface GraphTransaction {
    public Object before();
    public void after(Object state);
}

