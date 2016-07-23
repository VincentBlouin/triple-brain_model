/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.json;

import com.google.gson.reflect.TypeToken;
import guru.bubl.module.model.suggestion.SuggestionPojo;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.net.URI;
import java.util.Map;

public class SuggestionJson {

    public static JSONObject toJson(SuggestionPojo suggestionPojo) {
        try {
            return new JSONObject(JsonUtils.getGson().toJson(
                    suggestionPojo
            ));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public static SuggestionPojo fromJson(String json) {
        return JsonUtils.getGson().fromJson(json, SuggestionPojo.class);
    }

    public static JSONObject multipleToJson(Map<URI, SuggestionPojo> suggestionPojo) {
        try {
            return new JSONObject(JsonUtils.getGson().toJson(
                    suggestionPojo
            ));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public static Map<URI, SuggestionPojo> fromJsonArray(String json) {
        return JsonUtils.getGson().fromJson(
                json,
                new TypeToken<Map<URI, SuggestionPojo>>() {
                }.getType()
        );
    }
}
