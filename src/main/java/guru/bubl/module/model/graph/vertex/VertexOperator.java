/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.graph.vertex;

import guru.bubl.module.model.User;
import guru.bubl.module.model.graph.GraphElementOperator;
import guru.bubl.module.model.graph.ShareLevel;
import guru.bubl.module.model.graph.relation.Relation;
import guru.bubl.module.model.graph.relation.RelationOperator;
import guru.bubl.module.model.graph.fork.ForkOperator;

import java.net.URI;
import java.util.Map;

public interface VertexOperator extends ForkOperator, GraphElementOperator, Vertex {
    boolean hasEdge(Relation relation);

    RelationOperator getEdgeToDestinationVertex(Vertex destinationVertex);

    Boolean hasDestinationVertex(Vertex destinationVertex);

    Map<URI, RelationOperator> connectedEdges();

    void createUsingInitialValues(Map<String, Object> values);

    Boolean mergeTo(VertexOperator vertexOperator);

    void setShareLevel(ShareLevel shareLevel);

    Boolean makePattern();

    void undoPattern();

    Integer getNbPatternUsage();

}
