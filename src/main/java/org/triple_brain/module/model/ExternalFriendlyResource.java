package org.triple_brain.module.model;

import java.net.URI;
import java.net.URL;

/*
* Copyright Mozilla Public License 1.1
*/
public class ExternalFriendlyResource {
    private URI uri;
    private String label;
    private URL imageUrl;

    public static ExternalFriendlyResource withUriAndLabel(URI uri, String label){
        return new ExternalFriendlyResource(
                uri,
                label
        );
    }

    public static ExternalFriendlyResource withUriLabelAndImageUrl(URI uri, String label, URL imageUrl){
        return new ExternalFriendlyResource(
                uri,
                label,
                imageUrl
        );
    }

    private ExternalFriendlyResource(URI uri, String label){
        this.uri = uri;
        this.label = label;
    }

    private ExternalFriendlyResource(URI uri, String label, URL imageUrl){
        this.uri = uri;
        this.label = label;
        this.imageUrl = imageUrl;
    }

    public URI uri(){
        return uri;
    }

    public String label(){
        return label;
    }

    public Boolean hasImageUrl(){
        return imageUrl != null;
    }

    public URL imageUrl(){
        return imageUrl;
    }

    public void imageUrl(URL imageUrl){
        this.imageUrl = imageUrl;
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
