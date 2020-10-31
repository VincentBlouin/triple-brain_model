package guru.bubl.module.model.graph;

import guru.bubl.module.model.graph.tag.Tag;
import guru.bubl.module.model.graph.tag.TagPojo;

import java.net.URI;
import java.util.Set;

public class Tree {
    private Set<URI> urisOfGraphElements;

    private URI rootUri;

    private Tag rootAsTag;

    public static Tree withUrisOfGraphElementsAndRootUriAndTag(Set<URI> urisOfGraphElements, URI rootUri, Tag rootAsTag) {
        return new Tree(
                urisOfGraphElements,
                rootUri,
                rootAsTag
        );
    }

    private Tree(Set<URI> urisOfGraphElements, URI rootUri, Tag rootAsTag) {
        this.urisOfGraphElements = urisOfGraphElements;
        this.rootUri = rootUri;
        this.rootAsTag = rootAsTag;
    }

    public Set<URI> getUrisOfGraphElements() {
        return urisOfGraphElements;
    }

    public URI getRootUri() {
        return rootUri;
    }

    public Tag getRootAsTag() {
        return rootAsTag;
    }
}
