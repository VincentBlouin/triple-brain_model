/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.json;

import com.google.gson.reflect.TypeToken;
import guru.bubl.module.model.center_graph_element.CenterGraphElementPojo;

import java.util.List;
import java.util.Set;

public class CenterGraphElementsJson {

    public static String toJson(List<CenterGraphElementPojo> elements) {
        return JsonUtils.getGson().toJson(
                elements
        );
    }

    public static List<CenterGraphElementPojo> fromJson(String json) {
        return JsonUtils.getGson().fromJson(
                json,
                new TypeToken<List<CenterGraphElementPojo>>() {
                }.getType()
        );
    }
}
