package org.triple_brain.module.model.json.graph;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.triple_brain.module.model.graph.Vertex;
import org.triple_brain.module.model.graph.VertexInSubGraph;

/*
* Copyright Mozilla Public License 1.1
*/
public class VertexInSubGraphJson extends VertexJson {
    public static final String DISTANCE_FROM_CENTER_VERTEX = "distance_from_center_vertex";
    public static JSONObject toJson(VertexInSubGraph vertex) {
        try{
            return VertexJson.toJson(
                    vertex
            ).put(
                    DISTANCE_FROM_CENTER_VERTEX,
                    vertex.minDistanceFromCenterVertex()
            );
        }catch(JSONException e){
            throw new RuntimeException(e);
        }
    }
    public static JSONObject toJson(Vertex vertex) {
        return toJson(
                (VertexInSubGraph) vertex
        );
    }
}
