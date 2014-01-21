package org.triple_brain.module.model.graph;

import org.joda.time.DateTime;
import org.triple_brain.module.model.FriendlyResource;
import org.triple_brain.module.model.Image;

import java.net.URI;
import java.util.Set;

/*
* Copyright Mozilla Public License 1.1
*/
public class FriendlyResourcePojo implements FriendlyResource {

    private URI uri;
    private String label;
    private Set<Image> images;
    private String comment;
    private DateTime creationDate,
            lastModificationDate;

    public FriendlyResourcePojo(
            URI uri,
            String label,
            Set<Image> images,
            String comment,
            DateTime creationDate,
            DateTime lastModificationDate
    ) {
        this.uri = uri;
        this.label = label;
        this.images = images;
        this.comment = comment;
        this.creationDate = creationDate;
        this.lastModificationDate = lastModificationDate;
    }

    @Override
    public URI uri() {
        return uri;
    }

    @Override
    public boolean hasLabel() {
        return !label().isEmpty();
    }

    @Override
    public String label() {
        return label;
    }

    @Override
    public Set<Image> images() {
        return images;
    }

    @Override
    public Boolean gotImages() {
        return !images.isEmpty();
    }

    @Override
    public String comment() {
        return comment;
    }

    @Override
    public Boolean gotComments() {
        return !comment().isEmpty();
    }

    @Override
    public DateTime creationDate() {
        return creationDate;
    }

    @Override
    public DateTime lastModificationDate() {
        return lastModificationDate;
    }

    @Override
    public boolean equals(Object friendlyResourceToCompareAsObject) {
        FriendlyResource friendlyResourceToCompare = (FriendlyResource) friendlyResourceToCompareAsObject;
        return uri().equals(friendlyResourceToCompare.uri());
    }

    @Override
    public int hashCode() {
        return uri().hashCode();
    }
}
