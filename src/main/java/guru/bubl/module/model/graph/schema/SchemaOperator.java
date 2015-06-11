/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.graph.schema;

import guru.bubl.module.model.graph.GraphElementOperator;

public interface SchemaOperator extends Schema, GraphElementOperator {
    GraphElementOperator addProperty();
}
