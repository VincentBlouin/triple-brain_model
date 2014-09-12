/*
 * Copyright Vincent Blouin under the Mozilla Public License 1.1
 */

package org.triple_brain.module.model.json;

import com.google.gson.Gson;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.triple_brain.module.model.graph.FriendlyResourcePojo;

public class FriendlyResourceJson {

    private static Gson gson = new Gson();

    public static JSONObject toJson(FriendlyResourcePojo resource) {
        try {
            return new JSONObject(
                    gson.toJson(
                            resource
                    )
            );
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public static FriendlyResourcePojo fromJson(JSONObject json){
        return gson.fromJson(
                json.toString(),
                FriendlyResourcePojo.class
        );
    }
}
