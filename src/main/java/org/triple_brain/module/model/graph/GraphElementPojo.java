package org.triple_brain.module.model.graph;

import org.joda.time.DateTime;
import org.triple_brain.module.model.FriendlyResource;
import org.triple_brain.module.model.Image;
import org.triple_brain.module.model.UserUris;

import java.net.URI;
import java.util.HashSet;
import java.util.Set;

/*
* Copyright Mozilla Public License 1.1
*/
public class GraphElementPojo implements GraphElement {

    private FriendlyResource friendlyResource;
    private Set<FriendlyResource> genericIdentifications;
    private Set<FriendlyResource> sameAs;
    private Set<FriendlyResource> additionalTypes;

    public GraphElementPojo(
            FriendlyResource friendlyResource,
            Set<FriendlyResource> genericIdentifications,
            Set<FriendlyResource> sameAs,
            Set<FriendlyResource> additionalTypes
    ){
        this.friendlyResource = friendlyResource;
        this.genericIdentifications = genericIdentifications;
        this.sameAs = sameAs;
        this.additionalTypes = additionalTypes;
    }

    @Override
    public boolean hasLabel() {
        return friendlyResource.hasLabel();
    }

    @Override
    public Set<FriendlyResource> getGenericIdentifications() {
        return genericIdentifications;
    }

    @Override
    public Set<FriendlyResource> getSameAs() {
        return sameAs;
    }

    @Override
    public Set<FriendlyResource> getAdditionalTypes() {
        return additionalTypes;
    }

    @Override
    public Set<FriendlyResource> getIdentifications() {
        Set<FriendlyResource> identifications = new HashSet<>();
        identifications.addAll(getSameAs());
        identifications.addAll(getAdditionalTypes());
        identifications.addAll(getGenericIdentifications());
        return identifications;
    }

    @Override
    public String ownerUsername() {
        return UserUris.ownerUserNameFromUri(
                uri()
        );
    }

    @Override
    public URI uri() {
        return friendlyResource.uri();
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
    public DateTime creationDate() {
        return friendlyResource.creationDate();
    }

    @Override
    public DateTime lastModificationDate() {
        return friendlyResource.lastModificationDate();
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
