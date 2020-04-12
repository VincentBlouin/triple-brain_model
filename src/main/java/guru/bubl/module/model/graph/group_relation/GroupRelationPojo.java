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

    private TagPojo tag;
    private GraphElementPojo graphElement;
    private NbNeighborsPojo nbNeighbors;
    private ShareLevel shareLevel;
    private Set<EdgePojo> edgeChildren;
    private Set<GroupRelationPojo> groupRelationChildren;


    public GroupRelationPojo(URI uri) {
        this.graphElement = new GraphElementPojo(uri);
    }

    public GroupRelationPojo(URI uri, TagPojo tag) {
        this.graphElement = new GraphElementPojo(uri);
        this.tag = tag;
    }

    public GroupRelationPojo(GroupRelationOperator groupRelationOperator) {
        this.graphElement = new GraphElementPojo(groupRelationOperator);
        this.tag = groupRelationOperator.getTag();
    }

    public GroupRelationPojo(GraphElementPojo graphElement, TagPojo tag, NbNeighborsPojo nbNeighbors, ShareLevel shareLevel) {
        this.graphElement = graphElement;
        this.tag = tag;
        this.nbNeighbors = nbNeighbors;
        this.shareLevel = shareLevel;
    }

    @Override
    public Map<URI, TagPojo> getTags() {
        return new HashMap<URI, TagPojo>() {{
            put(tag.uri(), tag);
        }};
    }

    @Override
    public String getFont() {
        return tag.getFont();
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
        return tag.getShareLevel();
    }

    @Override
    public URI uri() {
        return graphElement.uri();
    }

    @Override
    public boolean hasLabel() {
        return tag.hasLabel();
    }

    @Override
    public String label() {
        return tag.label();
    }

    @Override
    public Set<Image> images() {
        return tag.images();
    }

    @Override
    public Boolean gotImages() {
        return tag.gotImages();
    }

    @Override
    public String comment() {
        return tag.comment();
    }

    @Override
    public Boolean gotComments() {
        return tag.gotComments();
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
        return tag.getColors();
    }

    @Override
    public NbNeighbors getNbNeighbors() {
        return nbNeighbors;
    }

    public GraphElementPojo getGraphElement() {
        return graphElement;
    }
}
