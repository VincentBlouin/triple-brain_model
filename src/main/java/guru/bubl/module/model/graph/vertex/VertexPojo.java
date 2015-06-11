/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.graph.vertex;

import guru.bubl.module.model.graph.FriendlyResourcePojo;
import guru.bubl.module.model.graph.GraphElementPojo;
import guru.bubl.module.model.graph.Identification;
import guru.bubl.module.model.graph.edge.EdgePojo;
import guru.bubl.module.model.Image;
import guru.bubl.module.model.suggestion.SuggestionPojo;

import java.net.URI;
import java.util.Date;
import java.util.Map;
import java.util.Set;

public class VertexPojo implements Vertex {

    private GraphElementPojo graphElement;
    private Integer numberOfConnectedEdges;
    private Map<URI, VertexInSubGraphPojo> includedVertices;
    private Map<URI, EdgePojo> includedEdges;
    private Map<URI, SuggestionPojo> suggestions;
    private Boolean isPublic;

    public VertexPojo(
            GraphElementPojo graphElement,
            Integer numberOfConnectedEdges,
            Map<URI, VertexInSubGraphPojo> includedVertices,
            Map<URI, EdgePojo> includedEdges,
            Map<URI, SuggestionPojo> suggestions,
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
        this(new GraphElementPojo(
                new FriendlyResourcePojo(
                        uri
                )
        ));
    }

    public VertexPojo(FriendlyResourcePojo friendlyResourcePojo) {
        this(new GraphElementPojo(
                friendlyResourcePojo
        ));
    }

    public VertexPojo(GraphElementPojo graphElementPojo) {
        this.graphElement = graphElementPojo;
    }

    @Override
    public Integer getNumberOfConnectedEdges() {
        return numberOfConnectedEdges;
    }

    @Override
    public Map<URI, SuggestionPojo> getSuggestions() {
        return suggestions;
    }

    public void addSuggestion(SuggestionPojo suggestion) {
        suggestions.put(
                suggestion.uri(),
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
    public Map<URI, ? extends Identification> getGenericIdentifications() {
        return graphElement.getGenericIdentifications();
    }

    @Override
    public Map<URI, ? extends Identification> getSameAs() {
        return graphElement.getSameAs();
    }

    @Override
    public Map<URI, ? extends Identification> getAdditionalTypes() {
        return graphElement.getAdditionalTypes();
    }

    @Override
    public Map<URI, ? extends Identification> getIdentifications() {
        return graphElement.getIdentifications();
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
    public String getOwnerUsername() {
        return graphElement.getOwnerUsername();
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

    @Override
    public URI getExternalResourceUri() {
        return graphElement.getExternalResourceUri();
    }
}
