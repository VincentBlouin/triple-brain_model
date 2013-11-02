package org.triple_brain.module.model.graph;

/**
 * Copyright Mozilla Public License 1.1
 */
public interface Edge extends GraphElement {
    public static final String EMPTY_LABEL = "";
    Vertex sourceVertex();
    Vertex destinationVertex();
    Vertex otherVertex(Vertex vertex);
    boolean hasVertex(Vertex vertex);
    void inverse();
}
