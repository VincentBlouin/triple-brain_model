/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package org.triple_brain.module.model.graph.schema;

import org.triple_brain.module.model.graph.GraphElementOperator;

public interface SchemaOperator extends Schema, GraphElementOperator {
    GraphElementOperator addProperty();
}
