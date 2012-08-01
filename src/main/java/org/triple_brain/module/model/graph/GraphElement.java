package org.triple_brain.module.model.graph;

/**
 * Copyright Mozilla Public License 1.1
 */
public interface GraphElement {
    public String id();
    public String label();
    public void label(String label);
    public boolean hasLabel();
}
