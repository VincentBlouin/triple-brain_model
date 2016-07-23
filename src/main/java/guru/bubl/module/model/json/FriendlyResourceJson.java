/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.json;

import com.google.gson.reflect.TypeToken;
import guru.bubl.module.model.graph.FriendlyResourcePojo;

import java.util.Set;

public class FriendlyResourceJson {

    public static String multipleToJson(Set<FriendlyResourcePojo> resources) {
        return JsonUtils.getGson().toJson(resources);
    }

    public static Set<FriendlyResourcePojo> fromJsonToSet(String json) {
        return JsonUtils.getGson().fromJson(
                json,
                new TypeToken<Set<FriendlyResourcePojo>>() {
                }.getType()
        );
    }
}
