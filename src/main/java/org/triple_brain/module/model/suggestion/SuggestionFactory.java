/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package org.triple_brain.module.model.suggestion;

public interface SuggestionFactory {
    public SuggestionOperator createFromPojo(
            SuggestionPojo suggestionAsJson
    );
}
