package org.triple_brain.module.model.graph;

import java.util.Set;

/**
 * Copyright Mozilla Public License 1.1
 */
public interface Graph {
    public Vertex vertexWithIdentifier(String identifier);
    public Edge edgeWithIdentifier(String identifier);
    public int numberOfEdgesAndVertices();
    public int numberOfEdges();
    public int numberOfVertices();
    public boolean containsVertex(Vertex vertex);
    public Set<Vertex> vertices();
    public Set<Edge> edges();
}
