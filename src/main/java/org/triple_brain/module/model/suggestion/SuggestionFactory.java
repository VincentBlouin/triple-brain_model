package org.triple_brain.module.model.suggestion;

/*
* Copyright Mozilla Public License 1.1
*/
public interface SuggestionFactory {
    public SuggestionOperator createFromPojo(
            SuggestionPojo suggestionAsJson
    );
}
