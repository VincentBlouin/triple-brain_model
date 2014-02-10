package org.triple_brain.module.model.graph.vertex;

import org.triple_brain.module.model.graph.GraphElementOperator;
import org.triple_brain.module.model.graph.edge.Edge;
import org.triple_brain.module.model.graph.edge.EdgeOperator;
import org.triple_brain.module.model.suggestion.SuggestionOperator;

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
    void addSuggestions(Set<SuggestionOperator> suggestions);
    void makePublic();
    void makePrivate();
    Set<EdgeOperator> connectedEdges();
}
