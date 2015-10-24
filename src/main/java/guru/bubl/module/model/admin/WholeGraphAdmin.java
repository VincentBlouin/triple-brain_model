/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.admin;

import guru.bubl.module.model.WholeGraph;
import guru.bubl.module.model.graph.vertex.VertexInSubGraphOperator;

import java.util.Set;

public interface WholeGraphAdmin {

    default void refreshNumberOfConnectedEdges() {
        Set<VertexInSubGraphOperator> vertices = getWholeGraph().getAllVertices();
        for (VertexInSubGraphOperator vertex : vertices) {
            vertex.setNumberOfConnectedEdges(
                    vertex.connectedEdges().size()
            );

        }
    }

    void refreshNumberOfReferencesToAllIdentifications();

    WholeGraph getWholeGraph();
}
