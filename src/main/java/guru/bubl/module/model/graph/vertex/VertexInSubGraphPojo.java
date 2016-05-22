/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.graph.vertex;

import guru.bubl.module.model.graph.FriendlyResourcePojo;
import guru.bubl.module.model.graph.GraphElementPojo;
import guru.bubl.module.model.graph.identification.IdentificationPojo;
import guru.bubl.module.model.graph.edge.Edge;
import guru.bubl.module.model.graph.edge.EdgePojo;
import guru.bubl.module.model.Image;
import guru.bubl.module.model.suggestion.Suggestion;
import guru.bubl.module.model.suggestion.SuggestionPojo;
import org.joda.time.DateTime;

import java.net.URI;
import java.util.*;

public class VertexInSubGraphPojo implements VertexInSubGraph {

    private VertexPojo vertex;

    @Deprecated
    public VertexInSubGraphPojo(VertexOperator vertexOperator) {
        this(
                new GraphElementPojo(vertexOperator),
                vertexOperator.getNumberOfConnectedEdges(),
                convertVertexSetToPojoMap(vertexOperator.getIncludedVertices()),
                convertEdgeSetToPojoMap(vertexOperator.getIncludedEdges()),
                convertSuggestionSetToPojo(vertexOperator.getSuggestions()),
                vertexOperator.isPublic()
        );
    }

    public VertexInSubGraphPojo(URI uri){
        this(
                new FriendlyResourcePojo(uri)
        );
    }

    public VertexInSubGraphPojo(URI uri, String label){
        this(
                new FriendlyResourcePojo(
                        uri,
                        label
                )
        );
    }

    public static Map<URI, VertexInSubGraphPojo> convertVertexSetToPojoMap(Map<URI, ? extends Vertex> vertices) {
        Map<URI, VertexInSubGraphPojo> verticesPojo = new HashMap<>();
        for (Vertex vertex : vertices.values()) {
            verticesPojo.put(
                    vertex.uri(),
                    (VertexInSubGraphPojo) vertex
            );
        }
        return verticesPojo;
    }

    public static Map<URI, SuggestionPojo> convertSuggestionSetToPojo(Map<URI, ? extends Suggestion> suggestions) {
        Map<URI, SuggestionPojo> suggestionsPojo = new HashMap<>();
        for (Suggestion suggestion : suggestions.values()) {
            suggestionsPojo.put(
                    suggestion.uri(),
                    (SuggestionPojo) suggestion
            );
        }
        return suggestionsPojo;
    }

    public static Map<URI, EdgePojo> convertEdgeSetToPojoMap(Map<URI, ? extends Edge> edges) {
        Map<URI, EdgePojo> edgesPojo = new HashMap<>();
        for (Edge edge : edges.values()) {
            edgesPojo.put(
                    edge.uri(),
                    (EdgePojo) edge
            );
        }
        return edgesPojo;
    }

    public VertexInSubGraphPojo(GraphElementPojo graphElementPojo) {
        this(
                new VertexPojo(graphElementPojo)
        );
    }

    public VertexInSubGraphPojo(FriendlyResourcePojo friendlyResourcePojo) {
        this(
                new VertexPojo(friendlyResourcePojo)
        );
    }

    public VertexInSubGraphPojo(VertexPojo vertex){
        this.vertex = vertex;
    }

    public VertexInSubGraphPojo(
            GraphElementPojo graphElement,
            Integer numberOfConnectedEdges,
            Map<URI, VertexInSubGraphPojo> includedVertices,
            Map<URI, EdgePojo> includedEdges,
            Map<URI, SuggestionPojo> suggestions,
            Boolean isPublic
    ) {
        this.vertex = new VertexPojo(
                graphElement,
                numberOfConnectedEdges,
                includedVertices,
                includedEdges,
                suggestions,
                isPublic
        );
    }

    @Override
    public Integer getNumberOfConnectedEdges() {
        return vertex.getNumberOfConnectedEdges();
    }

    @Override
    public Map<URI, SuggestionPojo> getSuggestions() {
        return vertex.getSuggestions();
    }

    @Override
    public Boolean isPublic() {
        return vertex.isPublic();
    }

    @Override
    public Map<URI, VertexInSubGraphPojo> getIncludedVertices() {
        return vertex.getIncludedVertices();
    }

    @Override
    public Map<URI, EdgePojo> getIncludedEdges() {
        return vertex.getIncludedEdges();
    }

    @Override
    public boolean hasLabel() {
        return vertex.hasLabel();
    }

    @Override
    public Map<URI, IdentificationPojo> getGenericIdentifications() {
        return vertex.getGenericIdentifications();
    }

    @Override
    public Map<URI, IdentificationPojo> getSameAs() {
        return vertex.getSameAs();
    }

    @Override
    public Map<URI, IdentificationPojo> getAdditionalTypes() {
        return vertex.getAdditionalTypes();
    }

    @Override
    public Map<URI, IdentificationPojo> getIdentifications() {
        return vertex.getIdentifications();
    }

    @Override
    public URI uri() {
        return vertex.uri();
    }

    @Override
    public String label() {
        return vertex.label();
    }

    @Override
    public Set<Image> images() {
        return vertex.images();
    }

    @Override
    public Boolean gotImages() {
        return vertex.gotImages();
    }

    @Override
    public String comment() {
        return vertex.comment();
    }

    @Override
    public Boolean gotComments() {
        return vertex.gotComments();
    }

    @Override
    public Date creationDate() {
        return vertex.creationDate();
    }

    @Override
    public Date lastModificationDate() {
        return vertex.lastModificationDate();
    }

    @Override
    public String getOwnerUsername() {
        return vertex.getOwnerUsername();
    }

    @Override
    public boolean equals(Object vertexToCompareAsObject) {
        return vertex.equals(vertexToCompareAsObject);
    }

    @Override
    public int hashCode() {
        return vertex.hashCode();
    }

    public GraphElementPojo getGraphElement() {
        return vertex.getGraphElement();
    }

    public void setCreationDate(DateTime date){
        getGraphElement().setCreationDate(date);
    }

}
