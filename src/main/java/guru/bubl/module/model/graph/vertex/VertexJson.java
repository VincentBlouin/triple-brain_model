/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.graph.vertex;

import guru.bubl.module.model.json.JsonUtils;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class VertexJson {

    public static JSONObject toJson(VertexPojo vertex) {
        try {
            return new JSONObject(JsonUtils.getGson().toJson(
                    vertex
            ));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }


    public static VertexPojo fromJson(JSONObject jsonObject) {
        return JsonUtils.getGson().fromJson(
                jsonObject.toString(),
                VertexPojo.class
        );
    }
}
