/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.content;

import guru.bubl.module.model.graph.subgraph.UserGraph;

public interface AllContentFactory {
    AllContent forUserGraph(UserGraph userGraph);
}
