/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.center_graph_element;

import guru.bubl.module.model.graph.GraphElement;

public interface CenterGraphElementOperatorFactory {
    CenterGraphElementOperator usingGraphElement(GraphElement element);
}
