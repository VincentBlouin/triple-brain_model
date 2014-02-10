package org.triple_brain.module.model.graph.edge;

import org.triple_brain.module.model.FriendlyResource;
import org.triple_brain.module.model.Image;
import org.triple_brain.module.model.graph.GraphElementPojo;
import org.triple_brain.module.model.graph.vertex.Vertex;
import org.triple_brain.module.model.graph.vertex.VertexInSubGraphPojo;

import java.net.URI;
import java.util.Date;
import java.util.Set;

/*
* Copyright Mozilla Public License 1.1
*/
public class EdgePojo implements Edge{

    private GraphElementPojo graphElement;
    private VertexInSubGraphPojo sourceVertex;
    private VertexInSubGraphPojo destinationVertex;

    @Deprecated
    public EdgePojo(
            EdgeOperator edgeOperator
    ){
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
    public Date creationDate() {
        return graphElement.creationDate();
    }

    @Override
    public Date lastModificationDate() {
        return graphElement.lastModificationDate();
    }

    @Override
    public boolean equals(Object edgeToCompareAsObject) {
        return graphElement.equals(edgeToCompareAsObject);
    }

    @Override
    public int hashCode() {
        return graphElement.hashCode();
    }

    public GraphElementPojo getGraphElement(){
        return graphElement;
    }
}
