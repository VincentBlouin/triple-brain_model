/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.json.graph;

import com.google.gson.reflect.TypeToken;
import guru.bubl.module.model.graph.schema.Schema;
import guru.bubl.module.model.graph.schema.SchemaPojo;
import guru.bubl.module.model.json.JsonUtils;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.util.Set;

public class SchemaJson {
    public static JSONObject toJson(Schema schema) {
        try {
            return new JSONObject(
                    JsonUtils.getGson().toJson(
                            schema
                    )
            );
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
    public static SchemaPojo fromJson(String json){
        return JsonUtils.getGson().fromJson(
                json,
                SchemaPojo.class
        );
    }

    public static Set<SchemaPojo> listFromJson(String json){
        return JsonUtils.getGson().fromJson(
                json,
                new TypeToken<Set<SchemaPojo>>() {
                }.getType()
        );
    }

    public static String jsonFromList(Set<SchemaPojo> schemaList){
        return JsonUtils.getGson().toJson(
                schemaList,
                new TypeToken<Set<SchemaPojo>>() {
                }.getType()
        );
    }
}
