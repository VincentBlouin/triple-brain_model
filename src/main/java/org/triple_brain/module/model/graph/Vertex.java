package org.triple_brain.module.model.graph;

import org.triple_brain.module.model.suggestion.Suggestion;

import java.util.List;
import java.util.Set;

/**
 * Copyright Mozilla  License 1.1
 */
public interface Vertex extends GraphElement {
    static final String EMPTY_LABEL = "";

    boolean hasEdge(Edge edge);

    void addOutgoingEdge(Edge edge);

    void removeOutgoingEdge(Edge edge);

    Edge edgeThatLinksToDestinationVertex(Vertex destinationVertex);

    Boolean hasDestinationVertex(Vertex destinationVertex);

    void addNeighbor(Vertex neighbor);

    Edge addVertexAndRelation();

    Edge addRelationToVertex(Vertex destinationVertex);

    void removeNeighbor(Vertex neighbor);

    Set<Edge> outGoingEdges();

    Set<Edge> connectedEdges();

    Integer getNumberOfConnectedEdges();

    void setNumberOfConnectedEdges(Integer numberOfConnectedEdges);

    List<String> hiddenConnectedEdgesLabel();

    void hiddenConnectedEdgesLabel(List<String> hiddenEdgeLabel);

    void addSuggestions(Suggestion... suggestions);

    Set<Suggestion> suggestions();

    Boolean isPublic();

    void makePublic();

    void makePrivate();

    Set<Vertex> getIncludedVertices();
}

