/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.graph.vertex;

import guru.bubl.module.model.graph.FriendlyResourcePojo;
import guru.bubl.module.model.graph.GraphElementPojo;
import guru.bubl.module.model.graph.ShareLevel;
import guru.bubl.module.model.graph.identification.IdentifierPojo;
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
    private Integer nbPublicNeighbors;
    private Integer nbFriendNeighbors;
    private Map<URI, VertexInSubGraphPojo> includedVertices;
    private Map<URI, EdgePojo> includedEdges;
    private Map<URI, SuggestionPojo> suggestions;
    private ShareLevel shareLevel;
    private Boolean isPattern = false;

    public VertexPojo(
            GraphElementPojo graphElement,
            Integer numberOfConnectedEdges,
            Integer nbPublicNeighbors,
            Integer nbFriendNeighbors,
            Map<URI, VertexInSubGraphPojo> includedVertices,
            Map<URI, EdgePojo> includedEdges,
            Map<URI, SuggestionPojo> suggestions,
            ShareLevel shareLevel
    ) {
        this.graphElement = graphElement;
        this.numberOfConnectedEdges = numberOfConnectedEdges;
        this.nbPublicNeighbors = nbPublicNeighbors;
        this.nbFriendNeighbors = nbFriendNeighbors;
        this.includedVertices = includedVertices;
        this.includedEdges = includedEdges;
        this.suggestions = suggestions;
        this.shareLevel = shareLevel;
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
    public Integer getNbPublicNeighbors() {
        return nbPublicNeighbors;
    }

    @Override
    public Integer getNbFriendNeighbors() {
        return nbFriendNeighbors;
    }

    public void setNbPublicNeighbors(Integer nbPublicNeighbors) {
        this.nbPublicNeighbors = nbPublicNeighbors;
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
        return shareLevel == ShareLevel.PUBLIC || shareLevel == ShareLevel.PUBLIC_WITH_LINK;
    }

    @Override
    public ShareLevel getShareLevel() {
        return shareLevel;
    }

    @Override
    public Map<URI, VertexInSubGraphPojo> getIncludedVertices() {
        return includedVertices;
    }

    @Override
    public Map<URI, EdgePojo> getIncludedEdges() {
        return includedEdges;
    }

    public void setAsPattern() {
        this.isPattern = true;
    }

    @Override
    public Boolean isPattern() {
        return isPattern;
    }

    @Override
    public Map<URI, IdentifierPojo> getIdentifications() {
        return graphElement.getIdentifications();
    }

    @Override
    public String getColors() {
        return graphElement.getColors();
    }

    @Override
    public String getFont() {
        return graphElement.getColors();
    }

    @Override
    public String getChildrenIndex() {
        return graphElement.getChildrenIndex();
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

    public void setUri(URI uri) {
        graphElement.getFriendlyResource().setUri(uri);
    }

    public GraphElementPojo getGraphElement() {
        return graphElement;
    }
}
