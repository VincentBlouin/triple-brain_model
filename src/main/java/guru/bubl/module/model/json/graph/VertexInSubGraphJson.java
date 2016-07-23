/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.json.graph;

import guru.bubl.module.model.graph.vertex.VertexInSubGraphPojo;
import guru.bubl.module.model.graph.vertex.VertexPojo;
import guru.bubl.module.model.json.JsonUtils;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class VertexInSubGraphJson{

    public static JSONObject toJson(VertexPojo vertex) {
        try{
            return new JSONObject(JsonUtils.getGson().toJson(
                    vertex
            ));
        }catch(JSONException e){
            throw new RuntimeException(e);
        }
    }

    public static JSONObject toJson(VertexInSubGraphPojo vertex) {
        try{
            return new JSONObject(JsonUtils.getGson().toJson(
                    vertex
            ));
        }catch(JSONException e){
            throw new RuntimeException(e);
        }
    }

    public static VertexInSubGraphPojo fromJson(JSONObject jsonObject){
        return JsonUtils.getGson().fromJson(
                jsonObject.toString(),
                VertexInSubGraphPojo.class
        );
    }
}
