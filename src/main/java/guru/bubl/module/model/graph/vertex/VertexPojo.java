/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.graph.vertex;

import guru.bubl.module.model.Image;
import guru.bubl.module.model.graph.FriendlyResourcePojo;
import guru.bubl.module.model.graph.graph_element.GraphElementPojo;
import guru.bubl.module.model.graph.ShareLevel;
import guru.bubl.module.model.graph.fork.NbNeighborsPojo;
import guru.bubl.module.model.graph.tag.TagPojo;

import java.net.URI;
import java.util.Date;
import java.util.Map;
import java.util.Set;

public class VertexPojo implements Vertex {

    private GraphElementPojo graphElement;
    private NbNeighborsPojo nbNeighbors = new NbNeighborsPojo();
    private ShareLevel shareLevel;
    private Boolean isPattern = false;

    public VertexPojo(VertexOperator vertexOperator) {
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

    public VertexPojo(
            GraphElementPojo graphElement,
            NbNeighborsPojo nbNeighbors,
            ShareLevel shareLevel
    ) {
        this.graphElement = graphElement;
        this.nbNeighbors = nbNeighbors;
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


    public NbNeighborsPojo getNbNeighbors() {
        return nbNeighbors;
    }


    public Boolean isPublic() {
        return shareLevel == ShareLevel.PUBLIC || shareLevel == ShareLevel.PUBLIC_WITH_LINK;
    }

    @Override
    public ShareLevel getShareLevel() {
        return shareLevel;
    }

    public void setAsPattern() {
        this.isPattern = true;
    }

    @Override
    public Boolean isPattern() {
        return isPattern;
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
    public URI getCopiedFromUri() {
        return graphElement.getCopiedFromUri();
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

    public void setCreationDate(Long creationDate) {
        graphElement.setCreationDate(creationDate);
    }

}
