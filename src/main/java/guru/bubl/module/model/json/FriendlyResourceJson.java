/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import guru.bubl.module.model.graph.FriendlyResourcePojo;

import java.util.Set;

public class FriendlyResourceJson {
    private static Gson gson = new Gson();

    public static String multipleToJson(Set<FriendlyResourcePojo> resources) {
        return gson.toJson(resources);
    }

    public static Set<FriendlyResourcePojo> fromJsonToSet(String json) {
        return gson.fromJson(
                json,
                new TypeToken<Set<FriendlyResourcePojo>>() {
                }.getType()
        );
    }
}
