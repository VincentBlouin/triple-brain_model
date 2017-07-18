/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.graph.subgraph;

import guru.bubl.module.model.graph.vertex.VertexOperator;

import java.net.URI;
import java.util.Map;

public interface SubGraphForker {
    Map<URI, VertexOperator> fork(SubGraph subGraph);
}
