/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.content.project;

import guru.bubl.module.model.graph.subgraph.UserGraph;

public interface ProjectContentFactory {
    ProjectContent forUserGraph(UserGraph userGraph);
}
