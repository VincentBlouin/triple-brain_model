/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.json.graph;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import guru.bubl.module.model.graph.IdentificationPojo;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import guru.bubl.module.model.graph.schema.Schema;
import guru.bubl.module.model.graph.schema.SchemaPojo;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

    public static Set<SchemaPojo> listFromJson(String json){
        return gson.fromJson(
                json,
                new TypeToken<Set<SchemaPojo>>() {
                }.getType()
        );
    }

    public static String jsonFromList(Set<SchemaPojo> schemaList){
        return gson.toJson(
                schemaList,
                new TypeToken<Set<SchemaPojo>>() {
                }.getType()
        );
    }
}
