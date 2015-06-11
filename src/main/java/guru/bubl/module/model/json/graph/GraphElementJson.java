/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.json.graph;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import guru.bubl.module.model.graph.GraphElementPojo;

import java.net.URI;
import java.util.Map;

public class GraphElementJson {
    private static Gson gson = new Gson();

    public static String multipleToJson(Map<URI, GraphElementPojo> elements){
        return gson.toJson(elements);
    }

    public static Map<URI, GraphElementPojo> fromJsonObjectToMap(String json) {
        return gson.fromJson(
                json,
                new TypeToken<Map<URI, GraphElementPojo>>() {
                }.getType()
        );
    }
}
