package org.triple_brain.module.model.graph.edge;

import org.triple_brain.module.model.graph.GraphElement;
import org.triple_brain.module.model.graph.vertex.Vertex;

/**
 * Copyright Mozilla Public License 1.1
 */
public interface Edge extends GraphElement {
    Vertex sourceVertex();
    Vertex destinationVertex();
    Vertex otherVertex(Vertex vertex);
    boolean hasVertex(Vertex vertex);
}
