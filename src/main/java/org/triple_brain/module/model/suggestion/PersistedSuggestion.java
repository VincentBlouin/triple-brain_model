package org.triple_brain.module.model.suggestion;

import java.net.URI;

/*
* Copyright Mozilla Public License 1.1
*/
public class PersistedSuggestion {

    private Suggestion suggestion;
    private URI id;

    public static PersistedSuggestion withSuggestionAndItsId(Suggestion suggestion, URI id){
        return new PersistedSuggestion(
                suggestion,
                id
        );
    }

    public PersistedSuggestion(Suggestion suggestion, URI id){
        this.suggestion = suggestion;
        this.id = id;
    }

    public URI id(){
        return id;
    }

    public Suggestion get(){
        return suggestion;
    }
}
