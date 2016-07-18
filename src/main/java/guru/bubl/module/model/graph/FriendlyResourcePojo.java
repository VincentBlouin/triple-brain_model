/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.graph;

import guru.bubl.module.common_utils.Uris;
import guru.bubl.module.model.FriendlyResource;
import guru.bubl.module.model.Image;
import guru.bubl.module.model.UserUris;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


public class FriendlyResourcePojo implements FriendlyResource {

    private URI uri;
    private String label,
            comment;
    private Set<Image> images;
    private Date creationDate,
            lastModificationDate;

    @Deprecated
    public FriendlyResourcePojo(
            FriendlyResourceOperator friendlyResourceOperator
    ) {
        this(
                friendlyResourceOperator.uri(),
                friendlyResourceOperator.label(),
                friendlyResourceOperator.images(),
                friendlyResourceOperator.comment(),
                friendlyResourceOperator.creationDate(),
                friendlyResourceOperator.lastModificationDate()
        );
    }

    public FriendlyResourcePojo(
            URI uri
    ) {
        this.uri = uri;
    }

    public FriendlyResourcePojo(
            String label
    ) {
        this.label = label;
    }

    public FriendlyResourcePojo(
            URI uri,
            String label
    ) {
        this.uri = uri;
        this.label = label;
    }

    public FriendlyResourcePojo(
            URI uri,
            String label,
            Set<Image> images,
            String comment,
            Date creationDate,
            Date lastModificationDate
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
        try {
            return Uris.decodeUriSafe(uri);
        }catch(UnsupportedEncodingException e){
            throw new RuntimeException(e);
        }
    }

    public void setUri(URI uri) {
        this.uri = uri;
    }

    @Override
    public boolean hasLabel() {
        return !label().isEmpty();
    }

    @Override
    public String label() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public Set<Image> images() {
        return images == null ?
                new HashSet<>() :
                images;
    }

    public void addImage(Image image){
        if(images == null){
            images = new HashSet<>();
        }
        images().add(image);
    }

    @Override
    public Boolean gotImages() {
        return images != null && !images.isEmpty();
    }

    @Override
    public String comment() {
        if(comment == null){
            return "";
        }
        return comment;
    }

    @Override
    public Boolean gotComments() {
        return !comment().isEmpty();
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public Date creationDate() {
        return creationDate;
    }

    @Override
    public Date lastModificationDate() {
        return lastModificationDate;
    }

    @Override
    public String getOwnerUsername() {
        return UserUris.ownerUserNameFromUri(uri);
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

    public void setLastModificationDate(Date lastModificationDate) {
        this.lastModificationDate = lastModificationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setImages(Set<Image> images) {
        this.images = images;
    }
}
