/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package org.triple_brain.module.model.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.triple_brain.module.model.suggestion.SuggestionPojo;

import java.net.URI;
import java.util.Map;

public class SuggestionJson {

    private static Gson gson = new Gson();

    public static JSONObject toJson(SuggestionPojo suggestionPojo) {
        try {
            return new JSONObject(gson.toJson(
                    suggestionPojo
            ));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public static SuggestionPojo fromJson(String json) {
        return gson.fromJson(json, SuggestionPojo.class);
    }

    public static JSONObject multipleToJson(Map<URI, SuggestionPojo> suggestionPojo) {
        try {
            return new JSONObject(gson.toJson(
                    suggestionPojo
            ));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public static Map<URI, SuggestionPojo> fromJsonArray(String json) {
        return gson.fromJson(
                json,
                new TypeToken<Map<URI, SuggestionPojo>>() {
                }.getType()
        );
    }
}
