package org.triple_brain.module.model.graph.vertex;

import org.triple_brain.module.model.graph.edge.Edge;

import java.net.URI;
import java.util.Set;

/*
* Copyright Mozilla Public License 1.1
*/
public interface VertexFactory {
    VertexInSubGraphOperator withUri(URI uri);
    VertexInSubGraphOperator createForOwnerUsername(String username);
    VertexInSubGraphOperator createFromGraphElements(
            Set<Vertex> includedVertices,
            Set<Edge> includedEdges
    );
}
