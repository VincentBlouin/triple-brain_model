package org.triple_brain.module.model.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.triple_brain.module.model.graph.vertex.VertexInSubGraphPojo;
import org.triple_brain.module.model.graph.vertex.VertexOperator;
import org.triple_brain.module.model.suggestion.SuggestionPojo;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
* Copyright Mozilla Public License 1.1
*/
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

    public static JSONArray multipleToJson(Set<SuggestionPojo> suggestionPojo) {
        try {
            return new JSONArray(gson.toJson(
                    suggestionPojo
            ));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

        public static Set<SuggestionPojo> fromJsonArray(String json) {
        return gson.fromJson(
                json,
                new TypeToken<Set<SuggestionPojo>>() {
                }.getType()
        );
    }

    public static JSONObject inVertex(VertexOperator vertexOperator) {
        try {
            return new JSONObject(
                    gson.toJson(
                            VertexInSubGraphPojo.convertSuggestionSetToPojo(
                                    vertexOperator.getSuggestions()
                            )
                    )
            );
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
