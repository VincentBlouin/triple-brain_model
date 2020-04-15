/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.graph.relation;

import guru.bubl.module.model.json.JsonUtils;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class RelationJson {

    public static JSONObject toJson(RelationPojo edge) {
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
    public static RelationPojo fromJson(JSONObject json){
        return JsonUtils.getGson().fromJson(
                json.toString(),
                RelationPojo.class
        );
    }
}
