package org.triple_brain.module.model;

import java.net.URI;

/*
* Copyright Mozilla Public License 1.1
*/
public class Suggestion {
    private URI typeUri ;
    private URI domainUri;
    private String label;

    public static Suggestion withTypeDomainAndLabel(URI typeUri, URI domainUri, String label){
        return new Suggestion(
                typeUri,
                domainUri,
                label
                );
    }

    private Suggestion(URI typeUri, URI domainUri, String label){
        this.typeUri = typeUri;
        this.domainUri = domainUri;
        this.label = label;
    }

    public URI typeUri(){
        return typeUri;
    }

    public URI domainUri(){
        return domainUri;
    }

    public String label(){
        return label;
    }
}
