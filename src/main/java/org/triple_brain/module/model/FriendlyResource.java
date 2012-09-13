package org.triple_brain.module.model;

import java.net.URI;

/*
* Copyright Mozilla Public License 1.1
*/
public class FriendlyResource {
    private URI uri;
    private String label;

    public static FriendlyResource withUriAndLabel(URI uri, String label){
        return new FriendlyResource(
                uri,
                label
        );
    }

    private FriendlyResource(URI uri, String label){
        this.uri = uri;
        this.label = label;
    }

    public URI uri(){
        return uri;
    }

    public String label(){
        return label;
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
