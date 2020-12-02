package guru.bubl.module.model.graph.tree_copier;

import guru.bubl.module.model.User;
import guru.bubl.module.model.graph.ShareLevel;
import guru.bubl.module.model.graph.Tree;

import java.net.URI;
import java.util.Map;

public interface TreeCopier {

    Map<URI, URI> copyTreeOfUser(
            Tree tree,
            User copiedUser
    );

    Map<URI, URI> copyTreeOfUserInShareLevel(
            Tree tree,
            User copiedUser,
            ShareLevel shareLevel
    );

    Map<URI, URI> copyTreeOfUserWithNewParentUri(
            Tree tree,
            User copiedUser,
            URI newParentUri
    );

    Map<URI, URI> copyTreeOfUserWithNewParentUriInShareLevel(
            Tree tree,
            User copiedUser,
            URI newParentUri,
            ShareLevel shareLevel
    );
}
