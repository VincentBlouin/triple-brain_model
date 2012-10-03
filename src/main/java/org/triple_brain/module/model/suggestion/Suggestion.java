package org.triple_brain.module.model.suggestion;

import org.triple_brain.module.model.ExternalFriendlyResource;

import java.net.URI;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
* Copyright Mozilla Public License 1.1
*/
public class Suggestion {
    private URI sameAsUri;
    private URI domainUri;
    private String label;
    private Set<SuggestionOrigin> origins;

    public static Suggestion withSameAsDomainLabelAndOrigins(URI sameAsUri, URI domainUri, String label, SuggestionOrigin... origins){
        return new Suggestion(
                sameAsUri,
                domainUri,
                label,
                origins
                );
    }

    private Suggestion(URI sameAs, URI domainUri, String label, SuggestionOrigin ... origins){
        this.sameAsUri = sameAs;
        this.domainUri = domainUri;
        this.label = label;
        this.origins = new HashSet<>(
                Arrays.asList(origins)
        );
    }

    public URI sameAsUri(){
        return sameAsUri;
    }

    public URI domainUri(){
        return domainUri;
    }

    public String label(){
        return label;
    }

    public Set<SuggestionOrigin> origins(){
        return origins;
    }

    public void removeOriginsThatDependOnResource(ExternalFriendlyResource externalResource){
        Iterator<SuggestionOrigin> originIterator = origins.iterator();
        while(originIterator.hasNext()){
            SuggestionOrigin suggestionOrigin = originIterator.next();
            if(suggestionOrigin.isTheIdentificationWithUri(
                    externalResource.uri()
            )){
                originIterator.remove();
            }
        }
    }
}
