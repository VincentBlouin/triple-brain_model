package org.triple_brain.module.model.json.graph;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.triple_brain.module.model.graph.Vertex;
import org.triple_brain.module.model.json.SuggestionJsonFields;
import org.triple_brain.module.model.suggestion.Suggestion;

/**
 * Copyright Mozilla Public License 1.1
 */
public class VertexJson extends GraphElementJson {
    public static final String SUGGESTIONS = "suggestions";
    public static final String IS_PUBLIC = "is_public";
    public static final String INCLUDED_VERTICES = "included_vertices";
    public static final String NUMBER_OF_CONNECTED_EDGES = "number_of_connected_edges";

    public static JSONObject toJson(Vertex vertex) {
        try {
            JSONObject jsonVertex = GraphElementJson.toJson(
                    vertex
            )
                    .put(
                            LABEL,
                            vertex.label().trim().isEmpty() ?
                                    Vertex.EMPTY_LABEL :
                                    vertex.label())
                    .put(
                            SUGGESTIONS, jsonSuggestions(vertex))
                    .put(
                            IS_PUBLIC,
                            vertex.isPublic()
                    )
                    .put(
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

    public static JSONObject toJsonAsIncludedVertex(Vertex vertex) {
        try {
            return new JSONObject().put(
                    LABEL,
                    vertex.label()
            ).put(
                    URI,
                    vertex.uri()
            );
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

    private static JSONArray includedVerticesJson(Vertex vertex) {
        JSONArray includedVertices = new JSONArray();
        for (Vertex includedVertex : vertex.getIncludedVertices()) {
            includedVertices.put(
                    toJsonAsIncludedVertex(includedVertex)
            );
        }
        return includedVertices;
    }
}
