package org.triple_brain.module.model.graph.vertex;

import org.triple_brain.module.model.graph.edge.Edge;
import org.triple_brain.module.model.graph.GraphElement;
import org.triple_brain.module.model.suggestion.Suggestion;

import java.net.URI;
import java.util.Map;
import java.util.Set;

/**
 * Copyright Mozilla  License 1.1
 */
public interface Vertex extends GraphElement {
    Integer getNumberOfConnectedEdges();
    Set<?extends Suggestion> getSuggestions();
    Boolean isPublic();
    Map<URI, ?extends Vertex> getIncludedVertices();
    Map<URI, ?extends Edge> getIncludedEdges();
}

