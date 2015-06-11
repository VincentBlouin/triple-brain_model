/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.admin;

import guru.bubl.module.model.WholeGraph;
import guru.bubl.module.model.graph.vertex.VertexInSubGraphOperator;
import guru.bubl.module.model.graph.vertex.VertexOperator;

import java.util.Iterator;

public class WholeGraphAdmin {
    private WholeGraph wholeGraph;
    public WholeGraphAdmin(WholeGraph wholeGraph){
        this.wholeGraph = wholeGraph;
    }
    public void refreshNumberOfConnectedEdges(){
        Iterator<VertexInSubGraphOperator> vertexIt = wholeGraph.getAllVertices();
        while(vertexIt.hasNext()){
            VertexOperator vertex = vertexIt.next();
            vertex.setNumberOfConnectedEdges(
                    vertex.connectedEdges().size()
            );
        }
    }
}
