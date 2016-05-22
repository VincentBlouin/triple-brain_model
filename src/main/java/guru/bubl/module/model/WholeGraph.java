/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model;

import guru.bubl.module.model.graph.GraphElementOperator;
import guru.bubl.module.model.graph.identification.IdentificationOperator;
import guru.bubl.module.model.graph.edge.EdgeOperator;
import guru.bubl.module.model.graph.schema.SchemaOperator;
import guru.bubl.module.model.graph.vertex.VertexInSubGraphOperator;

import java.util.Set;

public interface WholeGraph {
    Set<VertexInSubGraphOperator> getAllVertices();
    Set<EdgeOperator> getAllEdges();
    Set<SchemaOperator> getAllSchemas();
    Set<GraphElementOperator> getAllGraphElements();
    Set<IdentificationOperator> getAllIdentifications();
}
