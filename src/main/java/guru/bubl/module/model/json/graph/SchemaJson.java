/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.json.graph;

import com.google.gson.Gson;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import guru.bubl.module.model.graph.schema.Schema;
import guru.bubl.module.model.graph.schema.SchemaPojo;

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
