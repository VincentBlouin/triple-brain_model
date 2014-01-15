package org.triple_brain.module.model.graph.vertex;

import org.triple_brain.module.model.graph.edge.Edge;
import org.triple_brain.module.model.graph.GraphElement;
import org.triple_brain.module.model.suggestion.Suggestion;

import java.util.Set;

/**
 * Copyright Mozilla  License 1.1
 */
public interface Vertex extends GraphElement {
    Integer getNumberOfConnectedEdges();
    Set<Suggestion> suggestions();
    Boolean isPublic();
    Set<Vertex> getIncludedVertices();
    Set<Edge> getIncludedEdges();
}

