/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.graph.vertex;

import guru.bubl.module.model.graph.GraphElement;
import guru.bubl.module.model.graph.fork.Fork;

public interface Vertex extends Fork, GraphElement {
    Boolean isPattern();
}

