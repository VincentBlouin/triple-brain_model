package org.triple_brain.module.model.graph;

import org.triple_brain.module.model.suggestion.Suggestion;

import java.util.List;
import java.util.Set;

/**
 * Copyright Mozilla Public License 1.1
 */
public interface Vertex extends GraphElement {
    public static final String EMPTY_LABEL = "";
    public boolean hasEdge(Edge edge);
    public void addOutgoingEdge(Edge edge);
    public void removeOutgoingEdge(Edge edge);
    public Edge edgeThatLinksToDestinationVertex(Vertex destinationVertex);
    public Boolean hasDestinationVertex(Vertex destinationVertex);
    public void addNeighbor(Vertex neighbor);
    public Edge addVertexAndRelation();
    public Edge addRelationToVertex(Vertex destinationVertex);
    public void removeNeighbor(Vertex neighbor);
    public Set<Edge> outGoingEdges();
    public Set<Edge> connectedEdges();
    public List<String> hiddenConnectedEdgesLabel();
    public void hiddenConnectedEdgesLabel(List<String> hiddenEdgeLabel);
    public void addSuggestions(Suggestion... suggestions);
    public Set<Suggestion> suggestions();
    public Boolean isPublic();
    public void makePublic();
    public void makePrivate();
}

