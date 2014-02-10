package org.triple_brain.module.model.json.graph;

import com.google.gson.Gson;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.triple_brain.module.model.graph.SubGraphPojo;

/**
 * Copyright Mozilla Public License 1.1
 */
public class SubGraphJson {
    public static final String VERTICES = "vertices";
    public static final String EDGES = "edges";
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
