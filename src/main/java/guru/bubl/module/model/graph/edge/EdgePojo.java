/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.graph.edge;

import guru.bubl.module.model.graph.FriendlyResourcePojo;
import guru.bubl.module.model.graph.GraphElementPojo;
import guru.bubl.module.model.graph.IdentificationPojo;
import guru.bubl.module.model.graph.vertex.Vertex;
import guru.bubl.module.model.Image;
import guru.bubl.module.model.graph.vertex.VertexInSubGraphPojo;

import java.net.URI;
import java.util.Date;
import java.util.Map;
import java.util.Set;

public class EdgePojo implements Edge {

    private GraphElementPojo graphElement;
    private VertexInSubGraphPojo sourceVertex;
    private VertexInSubGraphPojo destinationVertex;

    @Deprecated
    public EdgePojo(
            EdgeOperator edgeOperator
    ) {
        this(
                new GraphElementPojo(edgeOperator),
                new VertexInSubGraphPojo(edgeOperator.sourceVertex()),
                new VertexInSubGraphPojo(edgeOperator.destinationVertex())
        );
    }

    public EdgePojo(
            GraphElementPojo graphElement,
            VertexInSubGraphPojo sourceVertex,
            VertexInSubGraphPojo destinationVertex
    ) {
        this.graphElement = graphElement;
        this.sourceVertex = sourceVertex;
        this.destinationVertex = destinationVertex;
    }

    public EdgePojo(
            GraphElementPojo graphElement
    ) {
        this.graphElement = graphElement;
    }

    public EdgePojo(
            URI uri,
            String label
    ) {
        graphElement = new GraphElementPojo(
                new FriendlyResourcePojo(
                        uri,
                        label
                )
        );
    }

    @Override
    public Vertex sourceVertex() {
        return sourceVertex;
    }

    public void setSourceVertex(VertexInSubGraphPojo vertex) {
        this.sourceVertex = vertex;
    }

    @Override
    public Vertex destinationVertex() {
        return destinationVertex;
    }

    public void setDestinationVertex(VertexInSubGraphPojo vertex) {
        this.destinationVertex = vertex;
    }

    @Override
    public Vertex otherVertex(Vertex vertex) {
        return sourceVertex().equals(vertex) ?
                destinationVertex() :
                sourceVertex();
    }

    @Override
    public boolean hasVertex(Vertex vertex) {
        return sourceVertex().equals(vertex) ||
                destinationVertex().equals(vertex);
    }

    @Override
    public Map<URI, ? extends IdentificationPojo> getGenericIdentifications() {
        return graphElement.getGenericIdentifications();
    }

    @Override
    public Map<URI, ? extends IdentificationPojo> getSameAs() {
        return graphElement.getSameAs();
    }

    @Override
    public Map<URI, ? extends IdentificationPojo> getAdditionalTypes() {
        return graphElement.getAdditionalTypes();
    }

    @Override
    public Map<URI, ? extends IdentificationPojo> getIdentifications() {
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
    public boolean equals(Object edgeToCompareAsObject) {
        return graphElement.equals(edgeToCompareAsObject);
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
