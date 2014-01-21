package org.triple_brain.module.model.graph.vertex;

import org.joda.time.DateTime;
import org.triple_brain.module.model.FriendlyResource;
import org.triple_brain.module.model.Image;
import org.triple_brain.module.model.graph.GraphElement;
import org.triple_brain.module.model.graph.edge.Edge;
import org.triple_brain.module.model.suggestion.Suggestion;

import java.net.URI;
import java.util.Set;

/*
* Copyright Mozilla Public License 1.1
*/
public class VertexInSubGraphPojo implements VertexInSubGraph{

    private GraphElement graphElement;
    private Integer numberOfConnectedEdges;
    private Set<Vertex> includedVertices;
    private Set<Edge> includedEdges;
    private Set<Suggestion> suggestions;
    private Boolean isPublic;
    private Integer minDistanceFromCenterVertex = -1;

    public VertexInSubGraphPojo(
            GraphElement graphElement,
            Integer numberOfConnectedEdges,
            Set<Vertex> includedVertices,
            Set<Edge> includedEdges,
            Set<Suggestion> suggestions,
            Boolean isPublic
    ){
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
        return suggestions;
    }

    @Override
    public Boolean isPublic() {
        return isPublic;
    }

    @Override
    public Set<Vertex> getIncludedVertices() {
        return includedVertices;
    }

    @Override
    public Set<Edge> getIncludedEdges() {
        return includedEdges;
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
    public DateTime creationDate() {
        return graphElement.creationDate();
    }

    @Override
    public DateTime lastModificationDate() {
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
}
