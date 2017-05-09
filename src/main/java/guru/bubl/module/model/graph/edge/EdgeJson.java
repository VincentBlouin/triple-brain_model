/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.graph.edge;

import com.google.gson.Gson;
import guru.bubl.module.model.json.JsonUtils;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import guru.bubl.module.model.graph.edge.EdgePojo;

public class EdgeJson{

    public static JSONObject toJson(EdgePojo edge) {
        try {
            return new JSONObject(
                    JsonUtils.getGson().toJson(
                            edge
                    )
            );
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
    public static EdgePojo fromJson(JSONObject json){
        return JsonUtils.getGson().fromJson(
                json.toString(),
                EdgePojo.class
        );
    }
}
