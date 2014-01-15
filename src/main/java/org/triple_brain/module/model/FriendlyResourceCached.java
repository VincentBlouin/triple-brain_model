package org.triple_brain.module.model;

import org.joda.time.DateTime;

import java.net.URI;
import java.util.HashSet;
import java.util.Set;

/*
* Copyright Mozilla Public License 1.1
*/
public class FriendlyResourceCached implements FriendlyResource{

    private URI uri;
    private String label = "";
    private Set<Image> images = new HashSet<>();
    private String description = "";
    private DateTime creationDate = new DateTime();
    private DateTime lastModificationDate = new DateTime();

    public static FriendlyResourceCached fromFriendlyResource(FriendlyResource friendlyResource){
        return new FriendlyResourceCached(
                friendlyResource
        );
    }

    protected FriendlyResourceCached(FriendlyResource friendlyResource){
        this.uri = friendlyResource.uri();
        this.label = friendlyResource.label();
        this.images = friendlyResource.images();
        this.description = friendlyResource.comment();
        this.creationDate = friendlyResource.creationDate();
        this.lastModificationDate = friendlyResource.lastModificationDate();
    }

    @Override
    public URI uri() {
        return uri;
    }

    @Override
    public String label() {
        return label;
    }

    @Override
    public void label(String label) {
        this.label = label;
    }

    @Override
    public Set<Image> images() {
        return images;
    }

    @Override
    public Boolean gotTheImages() {
        return !images().isEmpty();
    }

    @Override
    public String comment() {
        return description;
    }

    @Override
    public void comment(String comment) {
        this.description = comment;
    }

    @Override
    public Boolean gotComments() {
        return !description.isEmpty();
    }

    @Override
    public DateTime creationDate() {
        return creationDate;
    }

    @Override
    public DateTime lastModificationDate() {
        return lastModificationDate;
    }
}
