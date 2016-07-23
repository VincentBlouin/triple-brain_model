/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.json;

import com.google.gson.reflect.TypeToken;
import guru.bubl.module.model.Image;

import java.util.Set;

public class ImageJson {

    public static Set<Image> fromJson(String json) {
        return JsonUtils.getGson().fromJson(
                json,
                new TypeToken<Set<Image>>() {
                }.getType()
        );
    }

    public static String toJsonArray(Set<Image> images) {
        return JsonUtils.getGson().toJson(
                images
        );
    }
}
