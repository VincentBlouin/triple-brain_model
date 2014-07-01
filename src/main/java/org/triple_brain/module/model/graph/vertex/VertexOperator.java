package org.triple_brain.module.model.graph.vertex;

import com.google.api.client.json.Json;
import org.codehaus.jettison.json.JSONArray;
import org.triple_brain.module.model.graph.GraphElementOperator;
import org.triple_brain.module.model.graph.edge.Edge;
import org.triple_brain.module.model.graph.edge.EdgeOperator;
import org.triple_brain.module.model.suggestion.Suggestion;
import org.triple_brain.module.model.suggestion.SuggestionOperator;
import org.triple_brain.module.model.suggestion.SuggestionPojo;

import java.net.URI;
import java.util.Map;
import java.util.Set;

/*
* Copyright Mozilla Public License 1.1
*/
public interface VertexOperator extends GraphElementOperator, Vertex {
    boolean hasEdge(Edge edge);
    EdgeOperator edgeThatLinksToDestinationVertex(Vertex destinationVertex);
    Boolean hasDestinationVertex(Vertex destinationVertex);
    EdgeOperator addVertexAndRelation();
    EdgeOperator addRelationToVertex(Vertex destinationVertex);
    void setNumberOfConnectedEdges(Integer numberOfConnectedEdges);
    void addSuggestions(Set<SuggestionPojo> suggestions);
    void setSuggestions(Set<SuggestionPojo> suggestions);
    Map<URI, ?extends Suggestion> getSuggestions();
    void makePublic();
    void makePrivate();
    Set<EdgeOperator> connectedEdges();
}
