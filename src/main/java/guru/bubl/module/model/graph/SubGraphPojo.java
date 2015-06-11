/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.graph;

import guru.bubl.module.model.graph.edge.Edge;
import guru.bubl.module.model.graph.edge.EdgePojo;
import guru.bubl.module.model.graph.vertex.Vertex;
import guru.bubl.module.model.graph.vertex.VertexInSubGraph;
import guru.bubl.module.model.graph.vertex.VertexInSubGraphPojo;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class SubGraphPojo implements SubGraph {

    private Map<URI, VertexInSubGraphPojo> vertices = new HashMap<>();
    private Map<URI, EdgePojo> edges = new HashMap<>();

    public static SubGraphPojo withVerticesAndEdges(Map<URI, VertexInSubGraphPojo> vertices, Map<URI, EdgePojo> edges) {
        return new SubGraphPojo(vertices, edges);
    }

    protected SubGraphPojo(Map<URI, VertexInSubGraphPojo> vertices, Map<URI, EdgePojo> edges) {
        this.vertices = vertices;
        this.edges = edges;
    }

    @Override
    public VertexInSubGraph vertexWithIdentifier(URI identifier) {
        return vertices.get(
                identifier
        );
    }

    @Override
    public Edge edgeWithIdentifier(URI identifier) {
        return edges.get(
                identifier
        );
    }

    @Override
    public int numberOfEdgesAndVertices() {
        return numberOfEdges() +
                numberOfVertices();
    }

    @Override
    public int numberOfEdges() {
        return edges.size();
    }

    @Override
    public int numberOfVertices() {
        return vertices.size();
    }

    @Override
    public Boolean containsVertex(Vertex vertex) {
        return vertices.containsKey(
                vertex.uri()
        );
    }

    @Override
    public Boolean containsEdge(Edge edge) {
        return edges.containsKey(edge.uri());
    }

    @Override
    public Boolean hasEdgeWithUri(URI uri) {
        return edges.containsKey(uri);
    }

    @Override
    public Map<URI, VertexInSubGraphPojo> vertices() {
        return vertices;
    }

    @Override
    public Map<URI, EdgePojo> edges() {
        return edges;
    }

    public void addEdge(EdgePojo edge) {
        edges.put(
                edge.uri(),
                edge
        );
    }

    public void addVertex(VertexInSubGraphPojo vertex) {
        vertices.put(
                vertex.uri(),
                vertex
        );
    }
}
