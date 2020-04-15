/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.graph.relation;

import guru.bubl.module.model.graph.GraphElementOperator;
import guru.bubl.module.model.graph.ShareLevel;
import guru.bubl.module.model.graph.group_relation.GroupRelationPojo;

import java.net.URI;
import java.util.Map;

public interface RelationOperator extends Relation, GraphElementOperator {
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
