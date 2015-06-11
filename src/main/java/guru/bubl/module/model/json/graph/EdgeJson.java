/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.json.graph;

import com.google.gson.Gson;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import guru.bubl.module.model.graph.edge.EdgePojo;

public class EdgeJson{
    private static Gson gson = new Gson();

    public static JSONObject toJson(EdgePojo edge) {
        try {
            return new JSONObject(
                    gson.toJson(
                            edge
                    )
            );
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
    public static EdgePojo fromJson(JSONObject json){
        return gson.fromJson(
                json.toString(),
                EdgePojo.class
        );
    }
}
