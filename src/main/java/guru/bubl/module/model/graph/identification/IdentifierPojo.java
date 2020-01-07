/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.graph.identification;

import guru.bubl.module.model.Image;
import guru.bubl.module.model.graph.FriendlyResourcePojo;

import java.net.URI;
import java.util.Date;
import java.util.Set;

public class IdentifierPojo implements Identifier {

    URI relationExternalResourceUri = DEFAULT_IDENTIFIER_RELATION_EXTERNAL_URI;
    URI externalResourceUri;
    FriendlyResourcePojo friendlyResource;
    Integer nbReferences = 0;

    public IdentifierPojo(
            Integer nbReferences,
            FriendlyResourcePojo meta
    ) {
        this.nbReferences = nbReferences;
        this.friendlyResource = meta;
    }

    public IdentifierPojo(
            URI externalResourceUri,
            Identifier identification
    ) {
        friendlyResource = new FriendlyResourcePojo(externalResourceUri);
        this.externalResourceUri = identification.getExternalResourceUri();
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
        friendlyResource.setLastModificationDate(new Date().getTime());
    }

    public IdentifierPojo(
            URI externalResourceUri,
            Integer nbReferences,
            FriendlyResourcePojo friendlyResourcePojo
    ) {
        this.externalResourceUri = externalResourceUri;
        this.nbReferences = nbReferences;
        this.friendlyResource = friendlyResourcePojo;
    }

    public IdentifierPojo(
            URI externalResourceUri,
            FriendlyResourcePojo friendlyResourcePojo
    ) {
        this.externalResourceUri = externalResourceUri;
        this.friendlyResource = friendlyResourcePojo;
    }

    public IdentifierPojo(
            URI externalResourceUri
    ) {
        this.externalResourceUri = externalResourceUri;
        this.friendlyResource = new FriendlyResourcePojo("");
    }

    public IdentifierPojo(
            FriendlyResourcePojo friendlyResourcePojo
    ) {
        this.friendlyResource = friendlyResourcePojo;
    }

    @Override
    public URI getRelationExternalResourceUri() {
        return relationExternalResourceUri;
    }

    public void setRelationExternalResourceUri(URI relationExternalResourceUri) {
        this.relationExternalResourceUri = relationExternalResourceUri;
    }

    @Override
    public URI getExternalResourceUri() {
        return externalResourceUri;
    }

    @Override
    public Integer getNbReferences() {
        return nbReferences;
    }

    public IdentifierPojo setNbRefences(Integer nbReferences) {
        this.nbReferences = nbReferences;
        return this;
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
    public String getColors() {
        return friendlyResource.getColors();
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

    public void setLastModificationDate(Long date) {
        friendlyResource.setLastModificationDate(
                date
        );
    }

    public FriendlyResourcePojo getFriendlyResource() {
        return friendlyResource;
    }

    public void setCreationDate(Long date) {
        friendlyResource.setCreationDate(date);
    }

    public void setLabel(String label) {
        friendlyResource.setLabel(label);
    }

}
