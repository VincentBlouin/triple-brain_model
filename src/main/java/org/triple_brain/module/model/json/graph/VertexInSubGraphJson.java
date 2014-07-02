package org.triple_brain.module.model.json.graph;

import com.google.gson.Gson;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.triple_brain.module.model.graph.vertex.VertexInSubGraphPojo;
import org.triple_brain.module.model.graph.vertex.VertexPojo;

/*
* Copyright Mozilla Public License 1.1
*/
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