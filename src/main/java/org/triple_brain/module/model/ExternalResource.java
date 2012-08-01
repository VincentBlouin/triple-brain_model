package org.triple_brain.module.model;

import java.net.URI;

/*
* Copyright Mozilla Public License 1.1
*/
public class ExternalResource {
    private URI uri;
    private String label;

    public static ExternalResource withUriAndLabel(URI uri, String label){
        return new ExternalResource(
                uri,
                label
        );
    }

    private ExternalResource(URI uri, String label){
        this.uri = uri;
        this.label = label;
    }

    public URI uri(){
        return uri;
    }

    public String label(){
        return label;
    }
}
