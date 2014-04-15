package org.triple_brain.module.model;

import org.triple_brain.module.model.graph.edge.EdgeOperator;
import org.triple_brain.module.model.graph.vertex.VertexInSubGraphOperator;

import java.util.Iterator;

/*
* Copyright Mozilla Public License 1.1
*/
public interface WholeGraph {
    public Iterator<VertexInSubGraphOperator> getAllVertices();
    public Iterator<EdgeOperator> getAllEdges();
}
