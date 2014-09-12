/*
 * Copyright Vincent Blouin under the Mozilla Public License 1.1
 */

package org.triple_brain.module.model.graph.vertex;

import org.triple_brain.module.model.graph.edge.Edge;
import org.triple_brain.module.model.graph.GraphElement;
import org.triple_brain.module.model.suggestion.Suggestion;
import org.triple_brain.module.model.suggestion.SuggestionPojo;

import java.net.URI;
import java.util.Map;
import java.util.Set;

public interface Vertex extends GraphElement {
    Integer getNumberOfConnectedEdges();
    Set<SuggestionPojo> getSuggestions();
    Boolean isPublic();
    Map<URI, ?extends Vertex> getIncludedVertices();
    Map<URI, ?extends Edge> getIncludedEdges();
}

