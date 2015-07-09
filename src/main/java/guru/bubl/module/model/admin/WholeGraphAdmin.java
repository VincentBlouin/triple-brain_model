/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.admin;

import guru.bubl.module.model.WholeGraph;
import guru.bubl.module.model.graph.vertex.VertexInSubGraphOperator;
import guru.bubl.module.model.graph.vertex.VertexOperator;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class WholeGraphAdmin {
    private WholeGraph wholeGraph;

    public WholeGraphAdmin(WholeGraph wholeGraph) {
        this.wholeGraph = wholeGraph;
    }

    public void refreshNumberOfConnectedEdges() {
        Set<VertexInSubGraphOperator> vertices = wholeGraph.getAllVertices();
        for (VertexInSubGraphOperator vertex : vertices) {
            vertex.setNumberOfConnectedEdges(
                    vertex.connectedEdges().size()
            );

        }
    }
}
