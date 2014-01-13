package org.triple_brain.module.model.graph;

import org.triple_brain.module.model.suggestion.Suggestion;

import java.util.Set;

/**
 * Copyright Mozilla  License 1.1
 */
public interface Vertex extends GraphElement {
    static final String EMPTY_LABEL = "";

    boolean hasEdge(Edge edge);

    Edge edgeThatLinksToDestinationVertex(Vertex destinationVertex);

    Boolean hasDestinationVertex(Vertex destinationVertex);

    Edge addVertexAndRelation();

    Edge addRelationToVertex(Vertex destinationVertex);

    Set<Edge> connectedEdges();

    Integer getNumberOfConnectedEdges();

    void setNumberOfConnectedEdges(Integer numberOfConnectedEdges);

    void addSuggestions(Suggestion... suggestions);

    Set<Suggestion> suggestions();

    Boolean isPublic();

    void makePublic();

    void makePrivate();

    Set<Vertex> getIncludedVertices();

    Set<Edge> getIncludedEdges();
}

