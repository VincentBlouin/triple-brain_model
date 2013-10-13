package org.triple_brain.module.model.admin;

import org.triple_brain.module.model.WholeGraph;
import org.triple_brain.module.model.graph.Vertex;

import java.util.Iterator;

/*
* Copyright Mozilla Public License 1.1
*/
public class WholeGraphAdmin {
    private WholeGraph wholeGraph;
    public WholeGraphAdmin(WholeGraph wholeGraph){
        this.wholeGraph = wholeGraph;
    }
    public void refreshNumberOfConnectedEdges(){
        Iterator<Vertex> vertexIt = wholeGraph.getAllVertices();
        while(vertexIt.hasNext()){
            Vertex vertex = vertexIt.next();
            vertex.setNumberOfConnectedEdges(
                    vertex.connectedEdges().size()
            );
        }
    }
}
