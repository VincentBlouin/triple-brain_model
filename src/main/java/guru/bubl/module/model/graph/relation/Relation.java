/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.graph.relation;

import guru.bubl.module.model.graph.graph_element.GraphElement;
import guru.bubl.module.model.graph.ShareLevel;
import guru.bubl.module.model.graph.edge.Edge;

public interface Relation extends Edge, GraphElement {

    @Override
    default ShareLevel getShareLevel() {
        ShareLevel sourceShareLevel = source().getShareLevel();
        ShareLevel destinationShareLevel = destination().getShareLevel();
        return sourceShareLevel.getIndex() < destinationShareLevel.getIndex() ?
                sourceShareLevel : destinationShareLevel;
    }
}
