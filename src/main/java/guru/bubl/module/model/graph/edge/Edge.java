/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.graph.edge;

import guru.bubl.module.model.graph.GraphElement;
import guru.bubl.module.model.graph.ShareLevel;
import guru.bubl.module.model.graph.vertex.Vertex;

public interface Edge extends GraphElement {
    Vertex sourceVertex();

    Vertex destinationVertex();

    Vertex otherVertex(Vertex vertex);

    @Override
    default ShareLevel getShareLevel() {
        ShareLevel sourceShareLevel = sourceVertex().getShareLevel();
        ShareLevel destinationShareLevel = destinationVertex().getShareLevel();
        return sourceShareLevel.getIndex() < destinationShareLevel.getIndex() ?
                sourceShareLevel : destinationShareLevel;
    }
}
