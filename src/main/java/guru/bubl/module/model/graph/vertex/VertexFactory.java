/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.graph.vertex;

import guru.bubl.module.model.graph.edge.Edge;

import java.net.URI;
import java.util.Set;

public interface VertexFactory {
    VertexOperator withUri(URI uri);

    VertexOperator createForOwner(String username);
}
