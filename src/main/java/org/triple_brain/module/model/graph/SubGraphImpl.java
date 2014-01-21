package org.triple_brain.module.model.graph;

import org.triple_brain.module.model.graph.edge.Edge;
import org.triple_brain.module.model.graph.vertex.Vertex;
import org.triple_brain.module.model.graph.vertex.VertexInSubGraph;

import java.net.URI;
import java.util.HashSet;
import java.util.Set;

/*
* Copyright Mozilla Public License 1.1
*/
public class SubGraphImpl implements SubGraph{

    private Set<VertexInSubGraph> vertices = new HashSet<VertexInSubGraph>();
    private Set<Edge> edges = new HashSet<Edge>();

    public static SubGraphImpl withVerticesAndEdges(Set<VertexInSubGraph> vertices, Set<Edge> edges){
        return new SubGraphImpl(vertices, edges);
    }

    protected SubGraphImpl(Set<VertexInSubGraph> vertices, Set<Edge> edges){
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
        return vertices.contains(vertex);
    }

    @Override
    public Set<VertexInSubGraph> vertices() {
        return vertices;
    }

    @Override
    public Set<Edge> edges() {
        return edges;
    }
}
