/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package org.triple_brain.module.model.json.graph;

import com.google.gson.Gson;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.triple_brain.module.model.graph.SubGraphPojo;

public class SubGraphJson {
    private static Gson gson = new Gson();

    public static JSONObject toJson(SubGraphPojo graph) {
        try {
            return new JSONObject(
                    gson.toJson(
                            graph
                    )
            );
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public static SubGraphPojo fromJson(JSONObject jsonObject){
        return gson.fromJson(
                jsonObject.toString(),
                SubGraphPojo.class
        );
    }
}
