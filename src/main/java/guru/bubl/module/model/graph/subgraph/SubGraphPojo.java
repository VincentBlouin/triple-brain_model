/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.graph.subgraph;

import guru.bubl.module.model.graph.ShareLevel;
import guru.bubl.module.model.graph.edge.Edge;
import guru.bubl.module.model.graph.edge.EdgePojo;
import guru.bubl.module.model.graph.tag.TagPojo;
import guru.bubl.module.model.graph.vertex.Vertex;
import guru.bubl.module.model.graph.vertex.VertexInSubGraphPojo;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class SubGraphPojo implements SubGraph {

    private Map<URI, VertexInSubGraphPojo> vertices = new HashMap<>();
    private Map<URI, EdgePojo> edges = new HashMap<>();
    private TagPojo centerTag;

    public static SubGraphPojo withVerticesAndEdges(Map<URI, VertexInSubGraphPojo> vertices, Map<URI, EdgePojo> edges) {
        return new SubGraphPojo(vertices, edges);
    }

    public static SubGraphPojo withSingleVertex(VertexInSubGraphPojo vertex) {
        Map<URI, VertexInSubGraphPojo> vertices = new HashMap<>();
        vertices.put(vertex.uri(), vertex);
        return new SubGraphPojo(
                vertices,
                new HashMap<>()
        );
    }

    protected SubGraphPojo(Map<URI, VertexInSubGraphPojo> vertices, Map<URI, EdgePojo> edges) {
        this.vertices = vertices;
        this.edges = edges;
    }

    @Override
    public VertexInSubGraphPojo vertexWithIdentifier(URI identifier) {
        return vertices.get(
                identifier
        );
    }

    @Override
    public EdgePojo edgeWithIdentifier(URI identifier) {
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

    @Override
    public TagPojo getCenterMeta() {
        return centerTag;
    }

    public Boolean hasCenter(URI uri) {
        return this.getCenterMeta() != null || this.vertexWithIdentifier(uri) != null;
    }

    public void setCenterMeta(TagPojo tag) {
        this.centerTag = tag;
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

    public Boolean isEmpty() {
        return this.vertices().isEmpty();
    }

    public Map<URI, VertexInSubGraphPojo> getFriendsAndPublicIndexableVertices() {
        Map<URI, VertexInSubGraphPojo> friendAndPublicVertices = new HashMap<>();
        for (VertexInSubGraphPojo vertex : vertices().values()) {
            ShareLevel shareLevel = vertex.getShareLevel();
            if (shareLevel == ShareLevel.FRIENDS || shareLevel == ShareLevel.PUBLIC) {
                friendAndPublicVertices.put(
                        vertex.uri(),
                        vertex
                );
            }
        }
        return friendAndPublicVertices;
    }

    public Map<URI, VertexInSubGraphPojo> getPublicIndexableVertices() {
        Map<URI, VertexInSubGraphPojo> publicVertices = new HashMap<>();
        for (VertexInSubGraphPojo vertex : vertices().values()) {
            if (vertex.getShareLevel() == ShareLevel.PUBLIC) {
                publicVertices.put(
                        vertex.uri(),
                        vertex
                );
            }
        }
        return publicVertices;
    }
}
