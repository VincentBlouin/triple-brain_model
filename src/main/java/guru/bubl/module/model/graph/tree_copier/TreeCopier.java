package guru.bubl.module.model.graph.tree_copier;

import guru.bubl.module.model.User;
import guru.bubl.module.model.graph.Tree;

import java.net.URI;

public interface TreeCopier {
    URI ofAnotherUser(
            Tree tree,
            User copiedUser
    );
}
