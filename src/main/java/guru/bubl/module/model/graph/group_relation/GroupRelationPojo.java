package guru.bubl.module.model.graph.group_relation;

import guru.bubl.module.model.Image;
import guru.bubl.module.model.graph.GraphElementPojo;
import guru.bubl.module.model.graph.ShareLevel;
import guru.bubl.module.model.graph.edge.EdgePojo;
import guru.bubl.module.model.graph.tag.TagPojo;
import guru.bubl.module.model.graph.fork.NbNeighbors;
import guru.bubl.module.model.graph.fork.NbNeighborsPojo;

import java.net.URI;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GroupRelationPojo implements GroupRelation {

    private GraphElementPojo graphElement;
    private NbNeighborsPojo nbNeighbors;
    private ShareLevel shareLevel;

    public GroupRelationPojo(URI uri) {
        this.graphElement = new GraphElementPojo(uri);
    }

    public GroupRelationPojo(GroupRelationOperator groupRelationOperator) {
        this.graphElement = new GraphElementPojo(groupRelationOperator);
    }

    public GroupRelationPojo(GraphElementPojo graphElement, NbNeighborsPojo nbNeighbors, ShareLevel shareLevel) {
        this.graphElement = graphElement;
        this.nbNeighbors = nbNeighbors;
        this.shareLevel = shareLevel;
    }

    @Override
    public Map<URI, TagPojo> getTags() {
        return graphElement.getTags();
    }

    @Override
    public String getFont() {
        return graphElement.getFont();
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
    public ShareLevel getShareLevel() {
        return graphElement.getShareLevel();
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
    public String getColors() {
        return graphElement.getColors();
    }

    @Override
    public NbNeighbors getNbNeighbors() {
        return nbNeighbors;
    }

    public GraphElementPojo getGraphElement() {
        return graphElement;
    }
}
