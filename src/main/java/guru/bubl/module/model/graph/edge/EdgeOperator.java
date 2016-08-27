/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.graph.edge;

import guru.bubl.module.model.graph.GraphElementOperator;
import guru.bubl.module.model.graph.vertex.Vertex;
import guru.bubl.module.model.graph.vertex.VertexOperator;

import java.util.Map;

public interface EdgeOperator extends Edge, GraphElementOperator {
    void inverse();

    VertexOperator sourceVertex();

    VertexOperator destinationVertex();

    VertexOperator otherVertex(Vertex vertex);

    void changeSourceVertex(Vertex newSourceVertex);

    void changeDestinationVertex(Vertex newDestinationVertex);

    EdgeOperator forkUsingSourceAndDestinationVertexAndCache(
            Vertex sourceVertex,
            Vertex destinationVertex,
            Edge cache
    );

    EdgePojo createEdgeUsingInitialValues(Map<String, Object> values);
    EdgePojo createEdge();
}
