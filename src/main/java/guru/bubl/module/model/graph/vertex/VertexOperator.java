/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.graph.vertex;

import guru.bubl.module.model.User;
import guru.bubl.module.model.graph.GraphElementOperator;
import guru.bubl.module.model.graph.GraphElementPojo;
import guru.bubl.module.model.graph.PublicPrivateOperator;
import guru.bubl.module.model.graph.edge.Edge;
import guru.bubl.module.model.graph.edge.EdgeOperator;
import guru.bubl.module.model.graph.edge.EdgePojo;
import guru.bubl.module.model.suggestion.SuggestionPojo;

import java.net.URI;
import java.util.Date;
import java.util.Map;
import java.util.Set;

public interface VertexOperator extends GraphElementOperator, PublicPrivateOperator, Vertex {
    boolean hasEdge(Edge edge);
    EdgeOperator getEdgeThatLinksToDestinationVertex(Vertex destinationVertex);
    Boolean hasDestinationVertex(Vertex destinationVertex);
    EdgePojo addVertexAndRelation();
    EdgeOperator addRelationToVertex(Vertex destinationVertex);
    EdgeOperator acceptSuggestion(SuggestionPojo suggestion);
    void setNumberOfConnectedEdges(Integer numberOfConnectedEdges);
    void setNumberOfPublicConnectedEdges(Integer numberOfConnectedEdges);
    void addSuggestions(Map<URI, SuggestionPojo> suggestions);
    void setSuggestions(Map<URI, SuggestionPojo> suggestions);
    Set<EdgeOperator> connectedEdges();
    VertexOperator forkForUserUsingCache(User user, Vertex cache);
    void createUsingInitialValues(Map<String, Object> values);
}
