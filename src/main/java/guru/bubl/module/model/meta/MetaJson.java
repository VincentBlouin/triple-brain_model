/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.meta;

import com.google.gson.reflect.TypeToken;
import guru.bubl.module.model.graph.identification.IdentifierPojo;
import guru.bubl.module.model.json.JsonUtils;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.net.URI;
import java.util.Map;
import java.util.Set;

public class MetaJson {

    public static String toJson(Map<URI, IdentifierPojo> identifications) {
        return JsonUtils.getGson().toJson(
                identifications
        );
    }

    public static Map<URI, IdentifierPojo> fromJson(String json) {
        return JsonUtils.getGson().fromJson(
                json,
                new TypeToken<Map<URI, IdentifierPojo>>() {
                }.getType()
        );
    }

    public static Set<IdentifierPojo> getSetFromJson(String json) {
        return JsonUtils.getGson().fromJson(
                json,
                new TypeToken<Set<IdentifierPojo>>() {
                }.getType()
        );
    }

    public static String toJsonSet(Set<IdentifierPojo> metas) {
        return JsonUtils.getGson().toJson(
                metas
        );
    }

    public static IdentifierPojo singleFromJson(String json) {
        return JsonUtils.getGson().fromJson(
                json,
                IdentifierPojo.class
        );
    }

    public static JSONObject singleToJson(IdentifierPojo identification) {
        try {
            return new JSONObject(JsonUtils.getGson().toJson(
                    identification
            ));
        }catch(JSONException e){
            throw new RuntimeException(e);
        }
    }

}
