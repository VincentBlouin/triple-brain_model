package guru.bubl.module.model.graph.edge;

import guru.bubl.module.model.graph.graph_element.GraphElement;

import java.net.URI;

public interface Edge {
    URI sourceUri();

    URI destinationUri();

    URI uri();

    default URI getOtherForkUri(URI forkUri) {
        if (this.sourceUri() == null) {
            return null;
        }
        if (this.sourceUri().equals(forkUri)) {
            return this.destinationUri();
        } else if (this.destinationUri().equals(forkUri)) {
            return this.sourceUri();
        } else {
            return null;
        }
    }

    @Deprecated
    GraphElement source();

    @Deprecated
    GraphElement destination();
}
