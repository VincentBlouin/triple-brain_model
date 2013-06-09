package org.triple_brain.module.model.graph;

/**
 * Copyright Mozilla Public License 1.1
 */
public interface Edge extends GraphElement {
    public static final String EMPTY_LABEL = "relation";

    public abstract Vertex sourceVertex();

    public abstract Vertex destinationVertex();

    public abstract Vertex otherVertex(Vertex vertex);

    public abstract boolean hasVertex(Vertex vertex);

    public abstract void remove();
}
