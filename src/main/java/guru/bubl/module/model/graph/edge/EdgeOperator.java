/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.graph.edge;

import guru.bubl.module.model.graph.GraphElementOperator;
import guru.bubl.module.model.graph.ShareLevel;
import guru.bubl.module.model.graph.fork.Fork;
import guru.bubl.module.model.graph.group_relation.GroupRelationPojo;
import guru.bubl.module.model.graph.tag.TagPojo;
import guru.bubl.module.model.graph.vertex.VertexOperator;

import java.net.URI;
import java.util.Map;

public interface EdgeOperator extends Edge, GraphElementOperator {
    void inverse();

    void changeSource(
            URI newSourceUri,
            ShareLevel oldEndShareLevel,
            ShareLevel keptEndShareLevel,
            ShareLevel newEndShareLevel
    );

    void changeDestination(
            URI newDestinationUri,
            ShareLevel oldEndShareLevel,
            ShareLevel keptEndShareLevel,
            ShareLevel newEndShareLevel
    );

    EdgePojo createEdgeUsingInitialValues(Map<String, Object> values);

    EdgePojo createEdge();

    EdgePojo createEdgeWithAdditionalProperties(Map<String, Object> props);

    EdgePojo createWithShareLevel(ShareLevel shareLevel);

    GroupRelationPojo convertToGroupRelation(
            String newGroupRelationId,
            TagPojo tag,
            Boolean isNewTag,
            ShareLevel initialShareLevel
    );
}
