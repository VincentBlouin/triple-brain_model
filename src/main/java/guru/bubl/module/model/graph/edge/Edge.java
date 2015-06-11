/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.graph.edge;

import guru.bubl.module.model.graph.GraphElement;
import guru.bubl.module.model.graph.vertex.Vertex;

public interface Edge extends GraphElement {
    Vertex sourceVertex();
    Vertex destinationVertex();
    Vertex otherVertex(Vertex vertex);
    boolean hasVertex(Vertex vertex);
}
