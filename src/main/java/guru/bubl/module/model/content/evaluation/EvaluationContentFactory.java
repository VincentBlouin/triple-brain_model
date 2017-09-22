/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.content.evaluation;

import guru.bubl.module.model.graph.subgraph.UserGraph;

public interface EvaluationContentFactory {
    EvaluationContent forUserGraph(UserGraph userGraph);
}
