/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.graph.subgraph;

import guru.bubl.module.model.User;
import guru.bubl.module.model.graph.vertex.VertexPojo;

import java.net.URI;

public interface UserGraph {

    SubGraphPojo aroundForkUriInShareLevels(URI centerVertexUri, Integer... shareLevels);

    SubGraphPojo aroundForkUriWithDepthInShareLevels(URI centerVertexUri, Integer depth, Integer... shareLevels);

    VertexPojo createVertex();

    User user();

    Boolean haveElementWithId(URI id);
}
