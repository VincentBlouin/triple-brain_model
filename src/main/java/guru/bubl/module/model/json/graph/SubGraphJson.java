/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.json.graph;

import com.google.gson.Gson;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import guru.bubl.module.model.graph.subgraph.SubGraphPojo;

public class SubGraphJson {
    private static Gson gson = new Gson();

    public static JSONObject toJson(SubGraphPojo graph) {
        try {
            return new JSONObject(
                    gson.toJson(
                            graph
                    )
            );
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public static SubGraphPojo fromJson(JSONObject jsonObject){
        return fromJson(
                jsonObject.toString()
        );
    }

    public static SubGraphPojo fromJson(String jsonObject){
        return gson.fromJson(
                jsonObject,
                SubGraphPojo.class
        );
    }
}
