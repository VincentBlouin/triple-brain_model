package org.triple_brain.module.model.graph;

import org.triple_brain.module.model.graph.edge.Edge;
import org.triple_brain.module.model.graph.edge.EdgeOperator;
import org.triple_brain.module.model.graph.vertex.Vertex;
import org.triple_brain.module.model.graph.vertex.VertexInSubGraphOperator;

import java.net.URI;
import java.util.Set;

/**
 * Copyright Mozilla Public License 1.1
 */
public interface SubGraph {
    public VertexInSubGraphOperator vertexWithIdentifier(URI identifier);
    public Edge edgeWithIdentifier(URI identifier);
    public int numberOfEdgesAndVertices();
    public int numberOfEdges();
    public int numberOfVertices();
    public boolean containsVertex(Vertex vertex);
    public Set<VertexInSubGraphOperator> vertices();
    public Set<EdgeOperator> edges();
}
