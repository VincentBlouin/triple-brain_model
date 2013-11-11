package org.triple_brain.module.model.json.graph;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.triple_brain.module.model.graph.Edge;

/**
 * Copyright Mozilla Public License 1.1
 */
public class EdgeJson extends GraphElementJson {
    public static final String SOURCE_VERTEX_ID = "source_vertex_id";
    public static final String DESTINATION_VERTEX_ID = "destination_vertex_id";

    public static JSONObject toJson(Edge edge) {
        try {
            return GraphElementJson.toJson(edge)
                    .put(
                            LABEL,
                            edge.label().trim().isEmpty() ?
                                    Edge.EMPTY_LABEL :
                                    edge.label()
                    )
                    .put(
                            SOURCE_VERTEX_ID,
                            edge.sourceVertex().uri()
                    )
                    .put(
                            DESTINATION_VERTEX_ID,
                            edge.destinationVertex().uri()
                    );
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public static JSONObject toJsonAsIncludedEdge(Edge edge) {
        try {
            return GraphElementJson.toJsonAsIncludedGraphElement(
                    edge
            ).put(
                    SOURCE_VERTEX_ID,
                    edge.sourceVertex().uri()
            ).put(
                    DESTINATION_VERTEX_ID,
                    edge.destinationVertex().uri()
            );
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
