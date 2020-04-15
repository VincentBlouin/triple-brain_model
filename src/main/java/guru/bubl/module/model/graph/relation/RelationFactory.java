/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.graph.relation;

import java.net.URI;

public interface RelationFactory {
    RelationOperator withUri(URI uri);
}
