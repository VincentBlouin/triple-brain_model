/*
 * Copyright Vincent Blouin under the Mozilla Public License 1.1
 */

package org.triple_brain.module.model.json.graph;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.triple_brain.module.model.graph.GraphElementPojo;

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
