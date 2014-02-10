package org.triple_brain.module.model.graph;

import org.triple_brain.module.model.graph.edge.Edge;
import org.triple_brain.module.model.graph.edge.EdgePojo;
import org.triple_brain.module.model.graph.vertex.Vertex;
import org.triple_brain.module.model.graph.vertex.VertexInSubGraph;
import org.triple_brain.module.model.graph.vertex.VertexInSubGraphPojo;

import java.net.URI;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
* Copyright Mozilla Public License 1.1
*/
public class SubGraphPojo implements SubGraph{

    private Map<URI, VertexInSubGraphPojo> vertices = new HashMap<URI, VertexInSubGraphPojo>();
    private Set<EdgePojo> edges = new HashSet<EdgePojo>();

    public static SubGraphPojo withVerticesAndEdges(Map<URI, VertexInSubGraphPojo> vertices, Set<EdgePojo> edges){
        return new SubGraphPojo(vertices, edges);
    }

    protected SubGraphPojo(Map<URI, VertexInSubGraphPojo> vertices, Set<EdgePojo> edges){
        this.vertices = vertices;
        this.edges = edges;
    }

    @Override
    public VertexInSubGraph vertexWithIdentifier(URI identifier) {
        for(VertexInSubGraph vertex : vertices()){
            if(vertex.uri().equals(identifier)){
                return vertex;
            }
        }
        throw new RuntimeException("vertex with identifier " + identifier + " not found");
    }

    @Override
    public Edge edgeWithIdentifier(URI identifier) {
        for(Edge edge : edges()){
            if(edge.uri().equals(identifier)){
                return edge;
            }
        }
        throw new RuntimeException("edge with identifier " + identifier + " not found");
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
    public boolean containsVertex(Vertex vertex) {
        return vertices.containsValue(vertex);
    }

    @Override
    public Set<VertexInSubGraph> vertices() {
        Set<VertexInSubGraph> verticesInterface = new HashSet<>();
        verticesInterface.addAll(vertices.values());
        return verticesInterface;
    }

    @Override
    public Set<Edge> edges() {
        Set<Edge> edgesInterface = new HashSet<>();
        edgesInterface.addAll(edges);
        return edgesInterface;
    }

    public void addEdge(EdgePojo edge){
        edges.add(edge);
    }

    public void addVertex(VertexInSubGraphPojo vertex){
        vertices.put(
                vertex.uri(),
                vertex
        );
    }
}
