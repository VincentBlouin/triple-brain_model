/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import guru.bubl.module.model.Image;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;

import java.util.Set;

public class ImageJson {

    private static Gson gson = new Gson();

    public static Set<Image> fromJson(String json) {
        return gson.fromJson(
                json,
                new TypeToken<Set<Image>>() {
                }.getType()
        );
    }

    public static String toJsonArray(Set<Image> images) {
        return gson.toJson(
                images
        );
    }
}
