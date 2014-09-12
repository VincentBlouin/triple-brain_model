/*
 * Copyright Vincent Blouin under the Mozilla Public License 1.1
 */

package org.triple_brain.module.model.graph.schema;

import org.triple_brain.module.model.graph.FriendlyResourceOperator;
import org.triple_brain.module.model.graph.GraphElementOperator;

public interface SchemaOperator extends Schema, FriendlyResourceOperator {
    GraphElementOperator addProperty();
}
