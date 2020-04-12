/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class JsonUtils {
    static Gson gson = new GsonBuilder().setDateFormat(
            "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
    ).create();

    public static Gson getGson() {
        return gson;
    }

    public static JSONObject singleToJson(Object object) {
        try {
            return new JSONObject(JsonUtils.getGson().toJson(
                    object
            ));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
