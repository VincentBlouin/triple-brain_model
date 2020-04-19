/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.graph.graph_element;

import java.net.URI;

public interface GraphElementOperatorFactory {
    GraphElementOperator withUri(URI uri);
}
