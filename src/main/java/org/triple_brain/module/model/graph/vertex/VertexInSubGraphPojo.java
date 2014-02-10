package org.triple_brain.module.model.graph.vertex;

import org.triple_brain.module.model.FriendlyResource;
import org.triple_brain.module.model.Image;
import org.triple_brain.module.model.graph.FriendlyResourcePojo;
import org.triple_brain.module.model.graph.GraphElementPojo;
import org.triple_brain.module.model.graph.edge.Edge;
import org.triple_brain.module.model.graph.edge.EdgeOperator;
import org.triple_brain.module.model.graph.edge.EdgePojo;
import org.triple_brain.module.model.suggestion.Suggestion;
import org.triple_brain.module.model.suggestion.SuggestionOperator;
import org.triple_brain.module.model.suggestion.SuggestionPojo;

import java.net.URI;
import java.util.*;

/*
* Copyright Mozilla Public License 1.1
*/
public class VertexInSubGraphPojo implements VertexInSubGraph {

    private GraphElementPojo graphElement;
    private Integer numberOfConnectedEdges;
    private Map<URI, VertexInSubGraphPojo> includedVertices;
    private Set<EdgePojo> includedEdges;
    private Set<SuggestionPojo> suggestions;
    private Boolean isPublic;
    private Integer minDistanceFromCenterVertex = -1;

    @Deprecated
    public VertexInSubGraphPojo(VertexOperator vertexOperator) {
        this(
                new GraphElementPojo(vertexOperator),
                vertexOperator.getNumberOfConnectedEdges(),
                convertVertexOperatorSetToPojo(vertexOperator.getIncludedVertices()),
                convertEdgeOperatorSetToPojo(vertexOperator.getIncludedEdges()),
                convertSuggestionOperatorSetToPojo(vertexOperator.suggestions()),
                vertexOperator.isPublic()
        );
    }

    public static Map<URI, VertexInSubGraphPojo> convertVertexOperatorSetToPojo(Set<Vertex> vertices) {
        Map<URI, VertexInSubGraphPojo> verticesPojo = new HashMap<>();
        for (Vertex vertex : vertices) {
            verticesPojo.put(
                    vertex.uri(),
                    new VertexInSubGraphPojo(
                            (VertexOperator) vertex
                    )
            );
        }
        return verticesPojo;
    }

    public static Set<SuggestionPojo> convertSuggestionOperatorSetToPojo(Set<Suggestion> suggestions) {
        Set<SuggestionPojo> suggestionsPojo = new HashSet<>();
        for (Suggestion suggestion : suggestions) {
            suggestionsPojo.add(
                    new SuggestionPojo(
                            (SuggestionOperator) suggestion
                    )
            );
        }
        return suggestionsPojo;
    }

    public static Set<EdgePojo> convertEdgeOperatorSetToPojo(Set<Edge> edges) {
        Set<EdgePojo> edgesPojo = new HashSet<>();
        for (Edge edge : edges) {
            edgesPojo.add(
                    new EdgePojo(
                            (EdgeOperator) edge
                    )
            );
        }
        return edgesPojo;
    }

    public VertexInSubGraphPojo(FriendlyResourcePojo friendlyResourcePojo) {
        this.graphElement = new GraphElementPojo(
                friendlyResourcePojo
        );
    }

    public VertexInSubGraphPojo(
            GraphElementPojo graphElement,
            Integer numberOfConnectedEdges,
            Map<URI, VertexInSubGraphPojo> includedVertices,
            Set<EdgePojo> includedEdges,
            Set<SuggestionPojo> suggestions,
            Boolean isPublic
    ) {
        this.graphElement = graphElement;
        this.numberOfConnectedEdges = numberOfConnectedEdges;
        this.includedVertices = includedVertices;
        this.includedEdges = includedEdges;
        this.suggestions = suggestions;
        this.isPublic = isPublic;
    }

    @Override
    public Integer getNumberOfConnectedEdges() {
        return numberOfConnectedEdges;
    }

    @Override
    public Set<Suggestion> suggestions() {
        Set<Suggestion> suggestionSet = new HashSet<>();
        suggestionSet.addAll(suggestions);
        return suggestionSet;
    }

    @Override
    public Boolean isPublic() {
        return isPublic;
    }

    @Override
    public Set<Vertex> getIncludedVertices() {
        Set<Vertex> vertices = new HashSet<>();
        vertices.addAll(includedVertices.values());
        return vertices;
    }

    @Override
    public Set<Edge> getIncludedEdges() {
        Set<Edge> edges = new HashSet<>();
        edges.addAll(includedEdges);
        return edges;
    }

    @Override
    public boolean hasLabel() {
        return graphElement.hasLabel();
    }

    @Override
    public Set<FriendlyResource> getGenericIdentifications() {
        return graphElement.getGenericIdentifications();
    }

    @Override
    public Set<FriendlyResource> getSameAs() {
        return graphElement.getSameAs();
    }

    @Override
    public Set<FriendlyResource> getAdditionalTypes() {
        return graphElement.getAdditionalTypes();
    }

    @Override
    public Set<FriendlyResource> getIdentifications() {
        return graphElement.getIdentifications();
    }

    @Override
    public String ownerUsername() {
        return graphElement.ownerUsername();
    }

    @Override
    public URI uri() {
        return graphElement.uri();
    }

    @Override
    public String label() {
        return graphElement.label();
    }

    @Override
    public Set<Image> images() {
        return graphElement.images();
    }

    @Override
    public Boolean gotImages() {
        return graphElement.gotImages();
    }

    @Override
    public String comment() {
        return graphElement.comment();
    }

    @Override
    public Boolean gotComments() {
        return graphElement.gotComments();
    }

    @Override
    public Date creationDate() {
        return graphElement.creationDate();
    }

    @Override
    public Date lastModificationDate() {
        return graphElement.lastModificationDate();
    }

    @Override
    public Integer minDistanceFromCenterVertex() {
        return minDistanceFromCenterVertex;
    }

    @Override
    public VertexInSubGraph setMinDistanceFromCenterVertex(Integer minDistanceFromCenterVertex) {
        this.minDistanceFromCenterVertex = minDistanceFromCenterVertex;
        return this;
    }

    @Override
    public boolean equals(Object vertexToCompareAsObject) {
        return graphElement.equals(vertexToCompareAsObject);
    }

    @Override
    public int hashCode() {
        return graphElement.hashCode();
    }

    public GraphElementPojo getGraphElement() {
        return graphElement;
    }
}
