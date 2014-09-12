/*
 * Copyright Vincent Blouin under the Mozilla Public License 1.1
 */

package org.triple_brain.module.model.graph.vertex;

import org.triple_brain.module.model.graph.GraphElementOperator;
import org.triple_brain.module.model.graph.edge.Edge;
import org.triple_brain.module.model.graph.edge.EdgeOperator;
import org.triple_brain.module.model.suggestion.SuggestionPojo;

import java.util.Set;

public interface VertexOperator extends GraphElementOperator, Vertex {
    boolean hasEdge(Edge edge);
    EdgeOperator getEdgeThatLinksToDestinationVertex(Vertex destinationVertex);
    Boolean hasDestinationVertex(Vertex destinationVertex);
    EdgeOperator addVertexAndRelation();
    EdgeOperator addRelationToVertex(Vertex destinationVertex);
    void setNumberOfConnectedEdges(Integer numberOfConnectedEdges);
    void addSuggestions(Set<SuggestionPojo> suggestions);
    void setSuggestions(Set<SuggestionPojo> suggestions);
    void makePublic();
    void makePrivate();
    Set<EdgeOperator> connectedEdges();
}
