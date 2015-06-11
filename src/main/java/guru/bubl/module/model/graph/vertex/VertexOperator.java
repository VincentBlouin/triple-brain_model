/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.graph.vertex;

import guru.bubl.module.model.graph.edge.Edge;
import guru.bubl.module.model.graph.edge.EdgeOperator;
import guru.bubl.module.model.graph.GraphElementOperator;
import guru.bubl.module.model.suggestion.SuggestionPojo;

import java.net.URI;
import java.util.Map;
import java.util.Set;

public interface VertexOperator extends GraphElementOperator, Vertex {
    boolean hasEdge(Edge edge);
    EdgeOperator getEdgeThatLinksToDestinationVertex(Vertex destinationVertex);
    Boolean hasDestinationVertex(Vertex destinationVertex);
    EdgeOperator addVertexAndRelation();
    EdgeOperator addRelationToVertex(Vertex destinationVertex);
    EdgeOperator acceptSuggestion(SuggestionPojo suggestion);
    void setNumberOfConnectedEdges(Integer numberOfConnectedEdges);
    void addSuggestions(Map<URI, SuggestionPojo> suggestions);
    void setSuggestions(Map<URI, SuggestionPojo> suggestions);
    void makePublic();
    void makePrivate();
    Set<EdgeOperator> connectedEdges();
}
