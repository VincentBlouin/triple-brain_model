/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.graph;

import guru.bubl.module.model.graph.subgraph.SubGraph;
import guru.bubl.module.model.graph.subgraph.SubGraphPojo;
import guru.bubl.module.model.json.JsonUtils;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class SubGraphJson {


    public static JSONObject toJson(SubGraphPojo graph) {
        try {
            return new JSONObject(
                    SubGraphJson.toJsonString(graph)
            );
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public static String toJsonString(SubGraphPojo graph) {
        return JsonUtils.getGson().toJson(
                graph
        );
    }

    public static SubGraphPojo fromJson(JSONObject jsonObject) {
        return fromJson(
                jsonObject.toString()
        );
    }

    public static SubGraphPojo fromJson(String jsonObject) {
        return JsonUtils.getGson().fromJson(
                jsonObject,
                SubGraphPojo.class
        );
    }
}
