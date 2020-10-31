package guru.bubl.module.model.graph;

import java.net.URI;
import java.util.Set;

public class Tree {
    private Set<URI> urisOfGraphElements;

    private URI rootUri;

    public static Tree withUrisOfGraphElementsAndRootUri(Set<URI> urisOfGraphElements, URI rootUri) {
        return new Tree(
                urisOfGraphElements,
                rootUri
        );
    }

    private Tree(Set<URI> urisOfGraphElements, URI rootUri) {
        this.urisOfGraphElements = urisOfGraphElements;
        this.rootUri = rootUri;
    }

    public Set<URI> getUrisOfGraphElements() {
        return urisOfGraphElements;
    }

    public URI getRootUri() {
        return rootUri;
    }
}
