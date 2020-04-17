/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.graph.relation;

import guru.bubl.module.model.Image;
import guru.bubl.module.model.UserUris;
import guru.bubl.module.model.graph.FriendlyResourcePojo;
import guru.bubl.module.model.graph.GraphElement;
import guru.bubl.module.model.graph.GraphElementPojo;
import guru.bubl.module.model.graph.edge.EdgePojo;
import guru.bubl.module.model.graph.group_relation.GroupRelationPojo;
import guru.bubl.module.model.graph.tag.TagPojo;
import guru.bubl.module.model.graph.vertex.VertexPojo;

import java.net.URI;
import java.util.Date;
import java.util.Map;
import java.util.Set;

public class RelationPojo implements Relation, EdgePojo {

    private GraphElementPojo graphElement;
    private GroupRelationPojo sourceGroupRelation;
    private GroupRelationPojo destinationGroupRelation;
    private VertexPojo sourceVertex;
    private VertexPojo destinationVertex;

    @Deprecated
    public RelationPojo(
            RelationOperator relationOperator
    ) {
        this(
                new GraphElementPojo(relationOperator),
                new VertexPojo(relationOperator.sourceUri()),
                new VertexPojo(relationOperator.destinationUri())
        );
    }

    public RelationPojo(
            GraphElementPojo graphElement,
            VertexPojo sourceVertex,
            VertexPojo destinationVertex
    ) {
        this.graphElement = graphElement;
        this.sourceVertex = sourceVertex;
        this.destinationVertex = destinationVertex;
    }


    public RelationPojo(
            URI edgeUri,
            URI sourceVertexUri,
            URI destinationVertexUri
    ) {
        this.graphElement = new GraphElementPojo(edgeUri);
        this.sourceVertex = new VertexPojo(sourceVertexUri);
        this.destinationVertex = new VertexPojo(destinationVertexUri);
    }

    public RelationPojo(
            GraphElementPojo graphElement
    ) {
        this.graphElement = graphElement;
    }

    public RelationPojo(
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

    public GraphElement getSource() {
        return this.sourceGroupRelation == null ? sourceVertex : sourceGroupRelation;
    }

    @Override
    public URI sourceUri() {
        return getSource().uri();
    }

    @Override
    public void setSourceUri(URI sourceUri) {
        if (UserUris.isUriOfAGroupRelation(sourceUri)) {
            this.sourceGroupRelation = new GroupRelationPojo(sourceUri);
        } else {
            this.sourceVertex = new VertexPojo(sourceUri);
        }
    }

    @Override
    public void setDestinationUri(URI destinationUri) {
        if (UserUris.isUriOfAGroupRelation(destinationUri)) {
            this.destinationGroupRelation = new GroupRelationPojo(destinationUri);
        } else {
            this.destinationVertex = new VertexPojo(destinationUri);
        }
    }

    public void setSourceVertex(VertexPojo vertex) {
        this.sourceVertex = vertex;
    }

    public GraphElement getDestination() {
        return this.destinationGroupRelation == null ? destinationVertex : destinationGroupRelation;
    }

    @Override
    public URI destinationUri() {
        return getDestination().uri();
    }

    @Override
    public GraphElement source() {
        return getSource();
    }

    @Override
    public GraphElement destination() {
        return getDestination();
    }

    public VertexPojo getDestinationVertex() {
        return this.destinationVertex;
    }

    public void setDestinationVertex(VertexPojo vertex) {
        this.destinationVertex = vertex;
    }

    @Override
    public Map<URI, TagPojo> getTags() {
        return graphElement.getTags();
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
    public URI getPatternUri() {
        return graphElement.getPatternUri();
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

    public GraphElementPojo getGraphElement() {
        return graphElement;
    }


    public void setCreationDate(Long date) {
        getGraphElement().setCreationDate(date);
    }
}
