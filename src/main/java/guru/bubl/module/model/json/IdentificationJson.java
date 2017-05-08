/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.json;

import com.google.gson.reflect.TypeToken;
import guru.bubl.module.model.graph.identification.IdentifierPojo;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.net.URI;
import java.util.Map;

public class IdentificationJson {

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
