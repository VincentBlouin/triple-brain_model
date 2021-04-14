/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.graph.relation;

import guru.bubl.module.model.graph.graph_element.GraphElement;
import guru.bubl.module.model.graph.ShareLevel;
import guru.bubl.module.model.graph.edge.Edge;

import java.net.URI;

public interface Relation extends Edge, GraphElement {

    @Override
    default ShareLevel getShareLevel() {
        ShareLevel sourceShareLevel = source().getShareLevel();
        ShareLevel destinationShareLevel = destination().getShareLevel();
        return sourceShareLevel.getIndex() < destinationShareLevel.getIndex() ?
                sourceShareLevel : destinationShareLevel;
    }

    default URI getOtherForkUri(URI forkUri) {
        if (this.sourceUri().equals(forkUri)) {
            return this.destinationUri();
        } else if (this.destinationUri().equals(forkUri)) {
            return this.sourceUri();
        } else {
            return null;
        }
    }

}
