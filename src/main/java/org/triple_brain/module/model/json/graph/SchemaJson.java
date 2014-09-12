/*
 * Copyright Vincent Blouin under the Mozilla Public License 1.1
 */

package org.triple_brain.module.model.json.graph;

import com.google.gson.Gson;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.triple_brain.module.model.graph.schema.Schema;
import org.triple_brain.module.model.graph.schema.SchemaPojo;

public class SchemaJson {
    private static Gson gson = new Gson();
    public static JSONObject toJson(Schema schema) {
        try {
            return new JSONObject(
                    gson.toJson(
                            schema
                    )
            );
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
    public static SchemaPojo fromJson(String json){
        return gson.fromJson(
                json,
                SchemaPojo.class
        );
    }
}
