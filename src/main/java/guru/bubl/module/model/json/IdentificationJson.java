/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import guru.bubl.module.model.graph.IdentificationPojo;

import java.net.URI;
import java.util.Map;

public class IdentificationJson {

    private static Gson gson = new Gson();

    public static String toJson(Map<URI, IdentificationPojo> identifications) {
        return gson.toJson(
                identifications
        );
    }

    public static Map<URI, IdentificationPojo> fromJson(String json) {
        return gson.fromJson(
                json,
                new TypeToken<Map<URI, IdentificationPojo>>() {
                }.getType()
        );
    }

    public static IdentificationPojo singleFromJson(String json) {
        return gson.fromJson(
                json,
                IdentificationPojo.class
        );
    }

    public static JSONObject singleToJson(IdentificationPojo identification) {
        try {
            return new JSONObject(gson.toJson(
                    identification
            ));
        }catch(JSONException e){
            throw new RuntimeException(e);
        }
    }

}
