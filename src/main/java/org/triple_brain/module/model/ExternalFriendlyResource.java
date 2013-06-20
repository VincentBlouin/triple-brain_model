package org.triple_brain.module.model;

import org.apache.commons.lang.StringUtils;

import java.net.URI;
import java.util.HashSet;
import java.util.Set;

/*
* Copyright Mozilla Public License 1.1
*/
public class ExternalFriendlyResource {
    private URI uri;
    private String label = "";
    private String description = "";
    private Set<Image> images = new HashSet();

    public static ExternalFriendlyResource withUriAndLabel(URI uri, String label){
        return new ExternalFriendlyResource(
                uri,
                label
        );
    }

    public static ExternalFriendlyResource withUriLabelAndDescription(URI uri, String label, String description){
        return new ExternalFriendlyResource(
                uri,
                label
        ).description(description);
    }

    public static ExternalFriendlyResource withUriLabelAndImages(URI uri, String label, Set<Image> images){
        return new ExternalFriendlyResource(
                uri,
                label,
                images
        );
    }

    private ExternalFriendlyResource(URI uri, String label){
        this(
                uri,
                label,
                new HashSet<Image>()
        );
    }

    private ExternalFriendlyResource(URI uri, String label, Set<Image> images){
        this.uri = uri;
        this.label = label;
        this.images = images;
    }

    public URI uri(){
        return uri;
    }

    public String label(){
        return label;
    }

    public Set<Image> images(){
        return images;
    }

    public void images(Set<Image> images){
        this.images = images;
    }

    public Boolean gotTheImages(){
        return images().size() > 0;
    }

    public String description(){
        return description;
    }

    public ExternalFriendlyResource description(String description){
        this.description = description;
        return this;
    }

    public Boolean gotADescription(){
        return !StringUtils.isEmpty(description);
    }

    @Override
    public boolean equals(Object friendlyResourceToCompareAsObject) {
        ExternalFriendlyResource friendlyResourceToCompare = (ExternalFriendlyResource) friendlyResourceToCompareAsObject;
        return uri().equals(friendlyResourceToCompare.uri());
    }

    @Override
    public int hashCode() {
        return uri().hashCode();
    }
}
