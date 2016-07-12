/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.graph.edge;

import java.net.URI;

public interface EdgeFactory {
    EdgeOperator withUri(URI uri);
}
