/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.graph.vertex;

import guru.bubl.module.model.Image;
import guru.bubl.module.model.graph.FriendlyResourcePojo;
import guru.bubl.module.model.graph.GraphElementPojo;
import guru.bubl.module.model.graph.ShareLevel;
import guru.bubl.module.model.graph.tag.TagPojo;

import java.net.URI;
import java.util.Date;
import java.util.Map;
import java.util.Set;

public class VertexInSubGraphPojo implements VertexInSubGraph {

    private VertexPojo vertex;

    @Deprecated
    public VertexInSubGraphPojo(VertexOperator vertexOperator) {
        this(
                new GraphElementPojo(vertexOperator),
                new NbNeighborsPojo(
                        vertexOperator.getNbNeighbors().getPrivate(),
                        vertexOperator.getNbNeighbors().getFriend(),
                        vertexOperator.getNbNeighbors().getPublic()
                ),
                vertexOperator.getShareLevel()
        );
    }

    public VertexInSubGraphPojo(URI uri) {
        this(
                new FriendlyResourcePojo(uri)
        );
    }

    public VertexInSubGraphPojo(URI uri, String label) {
        this(
                new FriendlyResourcePojo(
                        uri,
                        label
                )
        );
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

    public VertexInSubGraphPojo(VertexPojo vertex) {
        this.vertex = vertex;
    }

    public VertexInSubGraphPojo(
            GraphElementPojo graphElement,
            NbNeighborsPojo nbNeighbors,
            ShareLevel shareLevel
    ) {
        this.vertex = new VertexPojo(
                graphElement,
                nbNeighbors,
                shareLevel
        );
    }

    public Boolean isPublic() {
        return vertex.isPublic();
    }

    @Override
    public NbNeighbors getNbNeighbors() {
        return vertex.getNbNeighbors();
    }

    public ShareLevel getShareLevel() {
        return vertex.getShareLevel();
    }

    @Override
    public Boolean isPattern() {
        return vertex.isPattern();
    }

    @Override
    public boolean hasLabel() {
        return vertex.hasLabel();
    }

    @Override
    public Map<URI, TagPojo> getTags() {
        return vertex.getTags();
    }

    @Override
    public String getColors() {
        return getGraphElement().getColors();
    }

    @Override
    public String getFont() {
        return getGraphElement().getColors();
    }

    @Override
    public String getChildrenIndex() {
        return getGraphElement().getChildrenIndex();
    }

    @Override
    public URI getPatternUri() {
        return getGraphElement().getPatternUri();
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

    public VertexPojo getVertex() {
        return vertex;
    }

    public void setCreationDate(Long date) {
        getGraphElement().setCreationDate(date);
    }

}
