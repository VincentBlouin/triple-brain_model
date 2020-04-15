/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.graph.relation;

import guru.bubl.module.model.graph.GraphElementOperator;
import guru.bubl.module.model.graph.ShareLevel;
import guru.bubl.module.model.graph.edge.EdgeOperator;
import guru.bubl.module.model.graph.group_relation.GroupRelationPojo;

import java.net.URI;
import java.util.Map;

public interface RelationOperator extends Relation, EdgeOperator, GraphElementOperator {
    void inverse();

    RelationPojo createEdgeUsingInitialValues(Map<String, Object> values);

    RelationPojo createEdge();

    RelationPojo createEdgeWithAdditionalProperties(Map<String, Object> props);

    RelationPojo createWithShareLevel(ShareLevel shareLevel);

    GroupRelationPojo convertToGroupRelation(
            String newGroupRelationId,
            ShareLevel initialShareLevel,
            String label
    );
}
