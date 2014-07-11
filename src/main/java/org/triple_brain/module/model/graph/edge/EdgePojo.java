package org.triple_brain.module.model.graph.edge;

import org.triple_brain.module.model.Image;
import org.triple_brain.module.model.graph.FriendlyResourcePojo;
import org.triple_brain.module.model.graph.GraphElementPojo;
import org.triple_brain.module.model.graph.IdentificationPojo;
import org.triple_brain.module.model.graph.vertex.Vertex;
import org.triple_brain.module.model.graph.vertex.VertexInSubGraphPojo;

import java.net.URI;
import java.util.Date;
import java.util.Map;
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

    public EdgePojo(
            URI uri,
            String label
    ){
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

    public void setSourceVertex(VertexInSubGraphPojo vertex){
        this.sourceVertex = vertex;
    }

    @Override
    public Vertex destinationVertex() {
        return destinationVertex;
    }

    public void setDestinationVertex(VertexInSubGraphPojo vertex){
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
    public Map<URI,?extends IdentificationPojo> getGenericIdentifications() {
        return graphElement.getGenericIdentifications();
    }

    @Override
    public Map<URI,?extends IdentificationPojo> getSameAs() {
        return graphElement.getSameAs();
    }

    @Override
    public Map<URI,?extends IdentificationPojo> getAdditionalTypes() {
        return graphElement.getAdditionalTypes();
    }

    @Override
    public Map<URI,?extends IdentificationPojo> getIdentifications() {
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
    public String getOwner() {
        return graphElement.getOwner();
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

    @Override
    public URI getExternalResourceUri() {
        return graphElement.getExternalResourceUri();
    }
}
