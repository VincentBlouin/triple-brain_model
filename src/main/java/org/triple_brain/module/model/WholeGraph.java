/*
 * Copyright Vincent Blouin under the Mozilla Public License 1.1
 */

package org.triple_brain.module.model;

import org.triple_brain.module.model.graph.edge.EdgeOperator;
import org.triple_brain.module.model.graph.schema.SchemaOperator;
import org.triple_brain.module.model.graph.vertex.VertexInSubGraphOperator;

import java.util.Iterator;

public interface WholeGraph {
    public Iterator<VertexInSubGraphOperator> getAllVertices();
    public Iterator<EdgeOperator> getAllEdges();
    public Iterator<SchemaOperator> getAllSchemas();
}
