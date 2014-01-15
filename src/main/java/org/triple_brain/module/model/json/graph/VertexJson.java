package org.triple_brain.module.model.json.graph;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.triple_brain.module.model.graph.edge.Edge;
import org.triple_brain.module.model.graph.vertex.Vertex;
import org.triple_brain.module.model.json.SuggestionJsonFields;
import org.triple_brain.module.model.suggestion.Suggestion;

/**
 * Copyright Mozilla Public License 1.1
 */
public class VertexJson extends GraphElementJson {
    public static final String SUGGESTIONS = "suggestions";
    public static final String IS_PUBLIC = "is_public";
    public static final String INCLUDED_VERTICES = "included_vertices";
    public static final String INCLUDED_EDGES = "included_edges";
    public static final String NUMBER_OF_CONNECTED_EDGES = "number_of_connected_edges";

    public static JSONObject toJson(Vertex vertex) {
        try {
            JSONObject jsonVertex = GraphElementJson.toJson(
                    vertex
            ).put(
                    LABEL,
                    vertex.label().trim().isEmpty() ?
                            "" :
                            vertex.label()
            ).put(
                    SUGGESTIONS, jsonSuggestions(vertex)
            ).put(
                    IS_PUBLIC,
                    vertex.isPublic()
            ).put(
                    INCLUDED_EDGES,
                    includedEdgesJson(vertex)
            ).put(
                    INCLUDED_VERTICES,
                    includedVerticesJson(vertex)
            ).put(
                    NUMBER_OF_CONNECTED_EDGES,
                    vertex.getNumberOfConnectedEdges()
            );
            return jsonVertex;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    private static JSONArray jsonSuggestions(Vertex vertex) {
        JSONArray suggestions = new JSONArray();
        for (Suggestion suggestion : vertex.suggestions()) {
            suggestions.put(
                    SuggestionJsonFields.toJson(
                            suggestion
                    )
            );
        }
        return suggestions;
    }

    private static JSONObject includedVerticesJson(Vertex vertex) {
        JSONObject includedGraphElements = new JSONObject();
        for (Vertex includedVertex : vertex.getIncludedVertices()) {
            try{
                includedGraphElements.put(
                        includedVertex.uri().toString(),
                        toJsonAsIncludedGraphElement(includedVertex)
                );
            }catch(JSONException e){
                throw new RuntimeException(e);
            }
        }
        return includedGraphElements;
    }

    private static JSONArray includedEdgesJson(Vertex vertex) {
        JSONArray includedGraphElements = new JSONArray();
        for (Edge edge : vertex.getIncludedEdges()) {
            includedGraphElements.put(
                    EdgeJson.toJsonAsIncludedEdge(edge)
            );
        }
        return includedGraphElements;
    }
}
