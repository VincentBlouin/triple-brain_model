/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.test;

import guru.bubl.module.model.graph.edge.EdgeOperator;
import guru.bubl.module.model.graph.vertex.Vertex;
import guru.bubl.module.model.graph.vertex.VertexOperator;

import java.util.HashSet;
import java.util.Set;

public class SubGraphOperator{

    private Set<VertexOperator> vertices = new HashSet<VertexOperator>();
    private Set<EdgeOperator> edges = new HashSet<EdgeOperator>();

    public static SubGraphOperator withVerticesAndEdges(Set<VertexOperator> vertices, Set<EdgeOperator> edges){
        return new SubGraphOperator(vertices, edges);
    }

    protected SubGraphOperator(Set<VertexOperator> vertices, Set<EdgeOperator> edges){
        this.vertices = vertices;
        this.edges = edges;
    }

    public boolean containsVertex(Vertex vertex) {
        return vertices.contains(vertex);
    }

    public Set<VertexOperator> vertices() {
        return vertices;
    }

    public Set<EdgeOperator> edges() {
        return edges;
    }
}
