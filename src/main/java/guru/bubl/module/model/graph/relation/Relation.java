/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.graph.relation;

import guru.bubl.module.model.graph.GraphElement;
import guru.bubl.module.model.graph.ShareLevel;

import java.net.URI;

public interface Relation extends GraphElement {
    URI sourceUri();

    URI destinationUri();

    @Deprecated
    GraphElement sourceFork();

    @Deprecated
    GraphElement destinationFork();

    @Override
    default ShareLevel getShareLevel() {
        ShareLevel sourceShareLevel = sourceFork().getShareLevel();
        ShareLevel destinationShareLevel = destinationFork().getShareLevel();
        return sourceShareLevel.getIndex() < destinationShareLevel.getIndex() ?
                sourceShareLevel : destinationShareLevel;
    }
}
