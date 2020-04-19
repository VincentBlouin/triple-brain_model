/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model;

import guru.bubl.module.model.graph.graph_element.GraphElementOperator;
import guru.bubl.module.model.graph.relation.RelationOperator;
import guru.bubl.module.model.graph.tag.TagOperator;
import guru.bubl.module.model.graph.vertex.VertexOperator;

import java.util.Set;

public interface WholeGraph {
    Set<VertexOperator> getAllVertices();

    Set<VertexOperator> getAllVerticesOfUser(User user);

    Set<RelationOperator> getAllEdges();

    Set<RelationOperator> getAllEdgesOfUser(User user);

    Set<GraphElementOperator> getAllGraphElements();

    Set<TagOperator> getAllTags();

    Set<TagOperator> getAllTagsOfUser(User user);
}
