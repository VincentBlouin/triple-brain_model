/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import guru.bubl.module.model.center_graph_element.CenterGraphElementPojo;

import java.util.Set;

public class CenterGraphElementsJson {
    private static Gson gson = new Gson();

    public static Set<CenterGraphElementPojo> fromJson(String json) {
        return gson.fromJson(
                json,
                new TypeToken<Set<CenterGraphElementPojo>>() {
                }.getType()
        );
    }
}
