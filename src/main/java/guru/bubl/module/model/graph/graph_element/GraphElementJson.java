/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.graph.graph_element;

import com.google.gson.reflect.TypeToken;
import guru.bubl.module.model.json.JsonUtils;

import java.net.URI;
import java.util.Map;

public class GraphElementJson {

    public static String multipleToJson(Map<URI, GraphElementPojo> elements){
        return JsonUtils.getGson().toJson(elements);
    }

    public static Map<URI, GraphElementPojo> fromJsonObjectToMap(String json) {
        return JsonUtils.getGson().fromJson(
                json,
                new TypeToken<Map<URI, GraphElementPojo>>() {
                }.getType()
        );
    }
}
