package org.triple_brain.module.model.suggestion;

import org.codehaus.jettison.json.JSONObject;

/*
* Copyright Mozilla Public License 1.1
*/
public interface SuggestionFactory {
    public Suggestion createFromJsonObject(
            JSONObject suggestionAsJson
    );
}
