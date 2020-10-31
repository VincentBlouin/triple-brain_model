package guru.bubl.module.model.graph.tree_copier;

import guru.bubl.module.model.User;

public interface TreeCopierFactory {
    TreeCopier forCopier(
            User copier
    );
}
