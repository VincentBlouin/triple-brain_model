/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.json;

import com.google.gson.reflect.TypeToken;
import guru.bubl.module.model.graph.identification.IdentificationPojo;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.net.URI;
import java.util.Map;

public class IdentificationJson {

    public static String toJson(Map<URI, IdentificationPojo> identifications) {
        return JsonUtils.getGson().toJson(
                identifications
        );
    }

    public static Map<URI, IdentificationPojo> fromJson(String json) {
        return JsonUtils.getGson().fromJson(
                json,
                new TypeToken<Map<URI, IdentificationPojo>>() {
                }.getType()
        );
    }

    public static IdentificationPojo singleFromJson(String json) {
        return JsonUtils.getGson().fromJson(
                json,
                IdentificationPojo.class
        );
    }

    public static JSONObject singleToJson(IdentificationPojo identification) {
        try {
            return new JSONObject(JsonUtils.getGson().toJson(
                    identification
            ));
        }catch(JSONException e){
            throw new RuntimeException(e);
        }
    }

}
