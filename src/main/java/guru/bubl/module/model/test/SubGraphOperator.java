/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.test;

import guru.bubl.module.model.graph.edge.Edge;
import guru.bubl.module.model.graph.edge.EdgeOperator;
import guru.bubl.module.model.graph.vertex.Vertex;
import guru.bubl.module.model.graph.vertex.VertexInSubGraphOperator;

import java.net.URI;
import java.util.HashSet;
import java.util.Set;

public class SubGraphOperator{

    private Set<VertexInSubGraphOperator> vertices = new HashSet<VertexInSubGraphOperator>();
    private Set<EdgeOperator> edges = new HashSet<EdgeOperator>();

    public static SubGraphOperator withVerticesAndEdges(Set<VertexInSubGraphOperator> vertices, Set<EdgeOperator> edges){
        return new SubGraphOperator(vertices, edges);
    }

    protected SubGraphOperator(Set<VertexInSubGraphOperator> vertices, Set<EdgeOperator> edges){
        this.vertices = vertices;
        this.edges = edges;
    }

    public VertexInSubGraphOperator vertexWithIdentifier(URI identifier) {
        for(VertexInSubGraphOperator vertex : vertices()){
            if(vertex.uri().equals(identifier)){
                return vertex;
            }
        }
        throw new RuntimeException("vertex with identifier " + identifier + " not found");
    }

    public Edge edgeWithIdentifier(URI identifier) {
        for(Edge edge : edges()){
            if(edge.uri().equals(identifier)){
                return edge;
            }
        }
        throw new RuntimeException("edge with identifier " + identifier + " not found");
    }

    public int numberOfEdgesAndVertices() {
        return numberOfEdges() +
                numberOfVertices();
    }

    public int numberOfEdges() {
        return edges.size();
    }

    public int numberOfVertices() {
        return vertices.size();
    }

    public boolean containsVertex(Vertex vertex) {
        return vertices.contains(vertex);
    }

    public Set<VertexInSubGraphOperator> vertices() {
        return vertices;
    }

    public Set<EdgeOperator> edges() {
        return edges;
    }
}
