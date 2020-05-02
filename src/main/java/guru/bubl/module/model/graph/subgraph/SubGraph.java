/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.graph.subgraph;

import guru.bubl.module.model.graph.group_relation.GroupRelationPojo;
import guru.bubl.module.model.graph.relation.Relation;
import guru.bubl.module.model.graph.tag.TagPojo;
import guru.bubl.module.model.graph.vertex.Vertex;

import java.net.URI;
import java.util.Map;

public interface SubGraph {
    Vertex vertexWithIdentifier(URI identifier);

    Relation edgeWithIdentifier(URI identifier);

    int numberOfEdgesAndVertices();

    int numberOfEdges();

    int numberOfVertices();

    Boolean containsVertex(Vertex vertex);

    Boolean containsEdge(Relation relation);

    Boolean hasEdgeWithUri(URI uri);

    Map<URI, ? extends Vertex> vertices();

    Map<URI, ? extends Relation> edges();

    TagPojo getCenterMeta();

    Boolean isEmpty();

    Map<URI, GroupRelationPojo> getGroupRelations();
}
