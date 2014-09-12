/*
 * Copyright Vincent Blouin under the Mozilla Public License 1.1
 */

package org.triple_brain.module.model.suggestion;

public interface SuggestionFactory {
    public SuggestionOperator createFromPojo(
            SuggestionPojo suggestionAsJson
    );
}
