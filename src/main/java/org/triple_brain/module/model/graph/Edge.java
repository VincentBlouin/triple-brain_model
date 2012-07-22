package org.triple_brain.module.model.graph;

/**
 * Copyright Mozilla Public License 1.1
 */
public abstract class Edge implements GraphElement {
    public static final String EMPTY_LABEL = "a property";

    public abstract Vertex sourceVertex();

    public abstract Vertex destinationVertex();

    public abstract void remove();

    @Override
    public boolean equals(Object edgeToCompareAsObject) {
        Edge edgeToCompare = (Edge) edgeToCompareAsObject;
        return id().equals(edgeToCompare.id());
    }

    @Override
    public int hashCode() {
        return id().hashCode();
    }
}
