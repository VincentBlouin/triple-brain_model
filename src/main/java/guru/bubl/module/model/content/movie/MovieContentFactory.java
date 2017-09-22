/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.content.movie;

import guru.bubl.module.model.graph.subgraph.UserGraph;

public interface MovieContentFactory {
    MovieContent forUserGraph(UserGraph userGraph);
}
