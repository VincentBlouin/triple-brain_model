package org.triple_brain.module.model.graph;


import org.triple_brain.module.model.Image;

import java.net.URI;
import java.util.Date;
import java.util.Set;

/*
* Copyright Mozilla Public License 1.1
*/
public class IdentificationPojo implements Identification{

    URI externalResourceUri;
    FriendlyResourcePojo friendlyResource;

    public IdentificationPojo(
            URI externalResourceUri,
            FriendlyResourcePojo friendlyResourcePojo
    ){
        this.externalResourceUri = externalResourceUri;
        this.friendlyResource = friendlyResourcePojo;
    }

    public IdentificationPojo(
            FriendlyResourcePojo friendlyResourcePojo
    ){
        this.friendlyResource = friendlyResourcePojo;
    }

    @Override
    public URI getExternalResourceUri() {
        return externalResourceUri;
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

    public void setComment(String comment){
        friendlyResource.setComment(comment);
    }

    @Override
    public boolean equals(Object toCompare) {
        return friendlyResource.equals(toCompare);
    }

    @Override
    public int hashCode() {
        return friendlyResource.hashCode();
    }
}
