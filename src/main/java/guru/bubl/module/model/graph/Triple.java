/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.graph;

import guru.bubl.module.model.graph.edge.Edge;
import guru.bubl.module.model.graph.vertex.Vertex;

public class Triple {

    private Edge edge;
    private Vertex source;
    private Vertex destination;

    public static Triple fromEdgeSourceAndDestination(
            Edge edge,
            Vertex source,
            Vertex destination
    ) {
        return new Triple(
                edge,
                source,
                destination
        );
    }

    public Triple(
            Edge edge,
            Vertex source,
            Vertex destination
    ) {
        this.edge = edge;
        this.source = source;
        this.destination = destination;
    }

    public Vertex getSource() {
        return source;
    }

    public Vertex getDestination() {
        return destination;
    }

    public Edge getEdge() {
        return edge;
    }
}
