/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.graph.subgraph;

import guru.bubl.module.model.User;

public interface SubGraphForkerFactory {
    SubGraphForker forUser(User user);
}