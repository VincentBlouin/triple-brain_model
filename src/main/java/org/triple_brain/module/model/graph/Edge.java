package org.triple_brain.module.model.graph;

/**
 * Copyright Mozilla Public License 1.1
 */
public abstract class Edge implements GraphElement{
    public abstract  Vertex sourceVertex();
    public abstract  Vertex destinationVertex();

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
