/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.json.graph;

import com.google.gson.Gson;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import guru.bubl.module.model.graph.vertex.VertexInSubGraphPojo;
import guru.bubl.module.model.graph.vertex.VertexPojo;

public class VertexInSubGraphJson{

    private static Gson gson = new Gson();

    public static JSONObject toJson(VertexPojo vertex) {
        try{
            return new JSONObject(gson.toJson(
                    vertex
            ));
        }catch(JSONException e){
            throw new RuntimeException(e);
        }
    }

    public static JSONObject toJson(VertexInSubGraphPojo vertex) {
        try{
            return new JSONObject(gson.toJson(
                    vertex
            ));
        }catch(JSONException e){
            throw new RuntimeException(e);
        }
    }

    public static VertexInSubGraphPojo fromJson(JSONObject jsonObject){
        return gson.fromJson(
                jsonObject.toString(),
                VertexInSubGraphPojo.class
        );
    }
}
