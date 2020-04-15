/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.graph.vertex;

import java.net.URI;

public interface VertexFactory {
    VertexOperator withUri(URI uri);

    VertexOperator createForOwner(String username);
}
