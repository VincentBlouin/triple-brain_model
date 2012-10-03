package org.triple_brain.module.model.suggestion;

import java.net.URI;

/*
* Copyright Mozilla Public License 1.1
*/
public class SuggestionOrigin {

    private String origin;

    public static SuggestionOrigin fromIdentificationWithUri(URI identificationUri){
        return new SuggestionOrigin(
                "identification_" +
                        identificationUri.toString()
        );
    }

    public SuggestionOrigin(String origin){
        this.origin = origin;
    }

    public Boolean isTheIdentificationWithUri(URI uri){
        return SuggestionOrigin.fromIdentificationWithUri(
                uri
        ).equals(this);
    }

    @Override
    public String toString(){
        return origin;
    }

    @Override
    public boolean equals(Object originToCompareAsObject) {
        SuggestionOrigin originToCompare = (SuggestionOrigin) originToCompareAsObject;
        return origin.equals(originToCompare.toString());
    }

    @Override
    public int hashCode() {
        return origin.hashCode();
    }
}
