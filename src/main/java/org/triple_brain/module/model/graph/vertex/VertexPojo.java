package org.triple_brain.module.model.graph.vertex;

import org.triple_brain.module.model.FriendlyResource;
import org.triple_brain.module.model.Image;
import org.triple_brain.module.model.graph.FriendlyResourcePojo;
import org.triple_brain.module.model.graph.GraphElementPojo;
import org.triple_brain.module.model.graph.edge.Edge;
import org.triple_brain.module.model.graph.edge.EdgePojo;
import org.triple_brain.module.model.suggestion.Suggestion;
import org.triple_brain.module.model.suggestion.SuggestionPojo;

import java.net.URI;
import java.util.*;

/*
 * Copyright Mozilla Public License 1.1
 */
public class VertexPojo implements Vertex {

    private GraphElementPojo graphElement;
    private Integer numberOfConnectedEdges;
    private Map<URI, VertexInSubGraphPojo> includedVertices;
    private Map<URI, EdgePojo> includedEdges;
    private Set<SuggestionPojo> suggestions;
    private Boolean isPublic;

    public VertexPojo(
            GraphElementPojo graphElement,
            Integer numberOfConnectedEdges,
            Map<URI, VertexInSubGraphPojo> includedVertices,
            Map<URI, EdgePojo> includedEdges,
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

    public VertexPojo(URI uri) {
        this.graphElement = new GraphElementPojo(
                new FriendlyResourcePojo(
                        uri
                )
        );
    }

    public VertexPojo(FriendlyResourcePojo friendlyResourcePojo) {
        this.graphElement = new GraphElementPojo(
                friendlyResourcePojo
        );
    }

    @Override
    public Integer getNumberOfConnectedEdges() {
        return numberOfConnectedEdges;
    }

    @Override
    public Set<SuggestionPojo> getSuggestions() {
        return suggestions;
    }

    public void addSuggestion(SuggestionPojo suggestion){
        suggestions.add(
                suggestion
        );
    }

    @Override
    public Boolean isPublic() {
        return isPublic;
    }

    @Override
    public Map<URI, VertexInSubGraphPojo> getIncludedVertices() {
        return includedVertices;
    }

    @Override
    public Map<URI, EdgePojo> getIncludedEdges() {
        return includedEdges;
    }

    @Override
    public Map<URI, ? extends FriendlyResource> getGenericIdentifications() {
        return graphElement.getGenericIdentifications();
    }

    @Override
    public Map<URI, ?extends FriendlyResource> getSameAs() {
        return graphElement.getSameAs();
    }

    @Override
    public Map<URI, ?extends FriendlyResource> getAdditionalTypes() {
        return graphElement.getAdditionalTypes();
    }

    @Override
    public Map<URI, ?extends FriendlyResource> getIdentifications() {
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
    public boolean hasLabel() {
        return graphElement.hasLabel();
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
