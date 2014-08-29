package org.triple_brain.module.model.graph.schema;

import org.triple_brain.module.model.Image;
import org.triple_brain.module.model.graph.FriendlyResourcePojo;
import org.triple_brain.module.model.graph.GraphElement;
import org.triple_brain.module.model.graph.GraphElementPojo;

import java.net.URI;
import java.util.Date;
import java.util.Map;
import java.util.Set;

/**
 * Copyright Mozilla Public License 1.1
 */
public class SchemaPojo implements Schema {

    private FriendlyResourcePojo friendlyResource;
    private Map<URI, GraphElementPojo> properties;

    public SchemaPojo(URI uri) {
        this(
                new FriendlyResourcePojo(uri)
        );
    }

    public SchemaPojo(FriendlyResourcePojo friendlyResource) {
        this.friendlyResource = friendlyResource;
    }

    public SchemaPojo(
            FriendlyResourcePojo friendlyResource,
            Map<URI, GraphElementPojo> properties
    ) {
        this.friendlyResource = friendlyResource;
        this.properties = properties;
    }

    @Override
    public URI uri() {
        return friendlyResource.uri();
    }

    @Override
    public boolean hasLabel() {
        return friendlyResource.hasLabel();
    }

    @Override
    public String label() {
        return friendlyResource.label();
    }

    @Override
    public Set<Image> images() {
        return friendlyResource.images();
    }

    @Override
    public Boolean gotImages() {
        return friendlyResource.gotImages();
    }

    @Override
    public String comment() {
        return friendlyResource.comment();
    }

    @Override
    public Boolean gotComments() {
        return friendlyResource.gotComments();
    }

    @Override
    public Date creationDate() {
        return friendlyResource.creationDate();
    }

    @Override
    public Date lastModificationDate() {
        return friendlyResource.lastModificationDate();
    }

    @Override
    public String getOwner() {
        return friendlyResource.getOwner();
    }

    public void setLabel(String label) {
        friendlyResource.setLabel(label);
    }

    @Override
    public Map<URI, GraphElementPojo> getProperties() {
        return properties;
    }

    @Override
    public boolean equals(Object graphElementToCompareAsObject) {
        return friendlyResource.equals(graphElementToCompareAsObject);
    }

    @Override
    public int hashCode() {
        return friendlyResource.hashCode();
    }
}
