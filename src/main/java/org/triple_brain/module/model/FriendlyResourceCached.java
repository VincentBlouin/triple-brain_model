package org.triple_brain.module.model;

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

    public static FriendlyResourceCached fromFriendlyResource(FriendlyResource friendlyResource){
        return new FriendlyResourceCached(
                friendlyResource
        );
    }

    protected FriendlyResourceCached(FriendlyResource friendlyResource){
        this.uri = friendlyResource.uri();
        this.label = friendlyResource.label();
        this.images = friendlyResource.images();
        this.description = friendlyResource.description();
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
    public String description() {
        return description;
    }

    @Override
    public void description(String description) {
        this.description = description;
    }

    @Override
    public Boolean gotADescription() {
        return !description.isEmpty();
    }

    @Override
    public void addImages(Set<Image> images) {
        images.addAll(images);
    }
}
