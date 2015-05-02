/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package org.triple_brain.module.model;

import org.triple_brain.module.model.graph.edge.EdgeOperator;
import org.triple_brain.module.model.graph.schema.SchemaOperator;
import org.triple_brain.module.model.graph.vertex.VertexInSubGraphOperator;

import java.util.Iterator;

public interface WholeGraph {
    Iterator<VertexInSubGraphOperator> getAllVertices();
    Iterator<EdgeOperator> getAllEdges();
    Iterator<SchemaOperator> getAllSchemas();
}
