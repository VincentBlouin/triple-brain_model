/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.graph.subgraph;

import guru.bubl.module.model.graph.edge.Edge;
import guru.bubl.module.model.graph.identification.Identifier;
import guru.bubl.module.model.graph.identification.IdentifierPojo;
import guru.bubl.module.model.graph.vertex.Vertex;
import guru.bubl.module.model.graph.vertex.VertexInSubGraph;

import java.net.URI;
import java.util.Map;

public interface SubGraph {
    VertexInSubGraph vertexWithIdentifier(URI identifier);
    Edge edgeWithIdentifier(URI identifier);
    int numberOfEdgesAndVertices();
    int numberOfEdges();
    int numberOfVertices();
    Boolean containsVertex(Vertex vertex);
    Boolean containsEdge(Edge edge);
    Boolean hasEdgeWithUri(URI uri);
    Map<URI, ? extends VertexInSubGraph> vertices();
    Map<URI, ? extends Edge> edges();
    IdentifierPojo getCenterMeta();
}
