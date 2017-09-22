/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.content.procedure;

import guru.bubl.module.model.graph.subgraph.UserGraph;

public interface ProcedureContentFactory {
    ProcedureContent forUserGraph(UserGraph userGraph);
}
