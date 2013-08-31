package org.triple_brain.module.model.graph;

import java.net.URI;
import java.util.Set;

/**
 * Copyright Mozilla Public License 1.1
 */
public interface SubGraph {
    public VertexInSubGraph vertexWithIdentifier(URI identifier);
    public Edge edgeWithIdentifier(URI identifier);
    public int numberOfEdgesAndVertices();
    public int numberOfEdges();
    public int numberOfVertices();
    public boolean containsVertex(Vertex vertex);
    public Set<VertexInSubGraph> vertices();
    public Set<Edge> edges();
}
