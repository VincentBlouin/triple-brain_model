/*
 * Copyright Vincent Blouin under the Mozilla Public License 1.1
 */

package org.triple_brain.module.model.graph;


import org.triple_brain.module.model.Image;

import java.net.URI;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class IdentificationPojo implements Identification {

    URI externalResourceUri;
    FriendlyResourcePojo friendlyResource;
    IdentificationType identificationType;

    public IdentificationPojo(
            URI uri,
            Identification identification
    ) {
        friendlyResource = new FriendlyResourcePojo(uri);
        externalResourceUri = identification.getExternalResourceUri();
        friendlyResource.setLabel(identification.label());
        if (identification.comment() != null) {
            friendlyResource.setComment(
                    identification.comment()
            );
        }
        if (identification.images() != null) {
            friendlyResource.setImages(
                    identification.images()
            );
        }
        friendlyResource.setLastModificationDate(new Date());
    }

    public IdentificationPojo(
            URI externalResourceUri,
            FriendlyResourcePojo friendlyResourcePojo
    ) {
        this.externalResourceUri = externalResourceUri;
        this.friendlyResource = friendlyResourcePojo;
    }

    public IdentificationPojo(
            FriendlyResourcePojo friendlyResourcePojo
    ) {
        this.friendlyResource = friendlyResourcePojo;
    }

    @Override
    public URI getExternalResourceUri() {
        return externalResourceUri;
    }

    public void setExternalResourceUri(URI externalResourceUri) {
        this.externalResourceUri = externalResourceUri;
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

    public void setImages(Set<Image> images) {
        friendlyResource.setImages(images);
    }

    @Override
    public Boolean gotImages() {
        return friendlyResource.gotImages();
    }

    @Override
    public String comment() {
        return friendlyResource.comment();
    }

    public void setComment(String comment) {
        friendlyResource.setComment(comment);
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
    public String getOwnerUsername() {
        return friendlyResource.getOwnerUsername();
    }

    @Override
    public boolean equals(Object toCompare) {
        return friendlyResource.equals(toCompare);
    }

    @Override
    public int hashCode() {
        return friendlyResource.hashCode();
    }

    public void setUri(URI uri) {
        friendlyResource.setUri(uri);
    }

    public void setLastModificationDate(Date date) {
        friendlyResource.setLastModificationDate(date);
    }

    public void setCreationDate(Date date) {
        friendlyResource.setCreationDate(date);
    }

    public IdentificationType getType() {
        return identificationType;
    }

    public void setType(IdentificationType identificationType) {
        this.identificationType = identificationType;
    }

}
