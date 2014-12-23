/*
 * Copyright Vincent Blouin under the Mozilla Public License 1.1
 */

package org.triple_brain.module.model.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.triple_brain.module.model.Image;
import org.triple_brain.module.model.graph.Identification;
import org.triple_brain.module.model.graph.IdentificationPojo;

import java.net.URI;
import java.util.Map;
import java.util.Set;

public class IdentificationJson {

    private static Gson gson = new Gson();

    public static String toJson(Map<URI, IdentificationPojo> identifications) {
        return gson.toJson(
                identifications
        );
    }

    public static Map<URI, IdentificationPojo> fromJson(String json) {
        return gson.fromJson(
                json,
                new TypeToken<Map<URI, IdentificationPojo>>() {
                }.getType()
        );
    }

    public static IdentificationPojo singleFromJson(String json) {
        return gson.fromJson(
                json,
                IdentificationPojo.class
        );
    }

    public static JSONObject singleToJson(IdentificationPojo identification) {
        try {
            return new JSONObject(gson.toJson(
                    identification
            ));
        }catch(JSONException e){
            throw new RuntimeException(e);
        }
    }

}
