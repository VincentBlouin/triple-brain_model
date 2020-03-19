/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.graph.vertex;

import guru.bubl.module.model.graph.GraphElement;

public interface Vertex extends VertexType, GraphElement {
    Boolean isPattern();
}

