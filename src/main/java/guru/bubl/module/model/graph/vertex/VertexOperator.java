/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.graph.vertex;

import guru.bubl.module.model.User;
import guru.bubl.module.model.graph.GraphElementOperator;
import guru.bubl.module.model.graph.ShareLevel;
import guru.bubl.module.model.graph.edge.Edge;
import guru.bubl.module.model.graph.edge.EdgeOperator;
import guru.bubl.module.model.graph.edge.EdgePojo;

import java.net.URI;
import java.util.Map;

public interface VertexOperator extends VertexTypeOperator, GraphElementOperator, Vertex {
    boolean hasEdge(Edge edge);

    EdgeOperator getEdgeThatLinksToDestinationVertex(Vertex destinationVertex);

    Boolean hasDestinationVertex(Vertex destinationVertex);

    EdgePojo addVertexAndRelation();

    EdgePojo addVertexAndRelationWithIds(String vertexId, String edgeId);

    EdgeOperator addRelationToVertex(VertexOperator destinationVertex);

    Map<URI, EdgeOperator> connectedEdges();

    VertexOperator forkForUserUsingCache(User user, Vertex cache);

    void createUsingInitialValues(Map<String, Object> values);

    Boolean mergeTo(VertexOperator vertexOperator);

    void setShareLevel(ShareLevel shareLevel);

    Boolean makePattern();

    void undoPattern();

    Integer getNbPatternUsage();

}
