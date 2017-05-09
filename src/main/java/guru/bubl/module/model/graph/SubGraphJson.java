/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.graph;

import guru.bubl.module.model.graph.subgraph.SubGraphPojo;
import guru.bubl.module.model.json.JsonUtils;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class SubGraphJson {


    public static JSONObject toJson(SubGraphPojo graph) {
        try {
            return new JSONObject(
                    JsonUtils.getGson().toJson(
                            graph
                    )
            );
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
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
