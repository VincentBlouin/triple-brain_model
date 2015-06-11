/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model;

import guru.bubl.module.model.graph.edge.EdgeOperator;
import guru.bubl.module.model.graph.schema.SchemaOperator;
import guru.bubl.module.model.graph.vertex.VertexInSubGraphOperator;

import java.util.Iterator;

public interface WholeGraph {
    Iterator<VertexInSubGraphOperator> getAllVertices();
    Iterator<EdgeOperator> getAllEdges();
    Iterator<SchemaOperator> getAllSchemas();
}
