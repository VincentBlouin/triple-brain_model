package guru.bubl.module.model.graph.tree_copier;

import guru.bubl.module.model.User;
import guru.bubl.module.model.graph.Tree;

import java.net.URI;
import java.util.Map;

public interface TreeCopier {
    Map<URI, URI> copyTreeOfUser(
            Tree tree,
            User copiedUser
    );

    Map<URI, URI> copyTreeOfUserWithNewParentUri(
            Tree tree,
            User copiedUser,
            URI newParentUri
    );
}
