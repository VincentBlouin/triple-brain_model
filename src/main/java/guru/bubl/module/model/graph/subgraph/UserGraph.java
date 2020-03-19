/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.graph.subgraph;

import guru.bubl.module.model.User;
import guru.bubl.module.model.graph.edge.EdgeOperator;
import guru.bubl.module.model.graph.vertex.VertexOperator;
import guru.bubl.module.model.graph.vertex.VertexPojo;

import java.net.URI;

public interface UserGraph {
    User user();

    Boolean haveElementWithId(URI id);

    SubGraphPojo aroundVertexUriInShareLevels(URI centerVertexUri, Integer... shareLevels);

    SubGraphPojo aroundVertexUriWithDepthInShareLevels(URI centerVertexUri, Integer depth, Integer... shareLevels);

    VertexOperator vertexWithUri(URI uri);

    EdgeOperator edgeWithUri(URI uri);

    VertexPojo createVertex();
}
