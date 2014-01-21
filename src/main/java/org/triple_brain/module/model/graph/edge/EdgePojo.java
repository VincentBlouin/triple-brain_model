package org.triple_brain.module.model.graph.edge;

import org.joda.time.DateTime;
import org.triple_brain.module.model.FriendlyResource;
import org.triple_brain.module.model.Image;
import org.triple_brain.module.model.graph.GraphElement;
import org.triple_brain.module.model.graph.vertex.Vertex;

import java.net.URI;
import java.util.Set;

/*
* Copyright Mozilla Public License 1.1
*/
public class EdgePojo implements Edge{

    private GraphElement graphElement;
    private Vertex sourceVertex;
    private Vertex destinationVertex;

    public EdgePojo(
            GraphElement graphElement,
            Vertex sourceVertex,
            Vertex destinationVertex
    ){
        this.graphElement = graphElement;
        this.sourceVertex = sourceVertex;
        this.destinationVertex = destinationVertex;
    }

    @Override
    public Vertex sourceVertex() {
        return sourceVertex;
    }

    @Override
    public Vertex destinationVertex() {
        return destinationVertex;
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
    public DateTime creationDate() {
        return graphElement.creationDate();
    }

    @Override
    public DateTime lastModificationDate() {
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
}
