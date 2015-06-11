/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.test;

import guru.bubl.module.model.User;
import guru.bubl.module.model.graph.SubGraphPojo;
import guru.bubl.module.model.graph.UserGraph;
import guru.bubl.module.model.graph.edge.Edge;
import guru.bubl.module.model.graph.edge.EdgePojo;
import guru.bubl.module.model.graph.vertex.Vertex;
import guru.bubl.module.model.graph.vertex.VertexInSubGraphPojo;
import guru.bubl.module.model.graph.vertex.VertexOperator;

public interface GraphComponentTest {
    int numberOfEdgesAndVertices();
    SubGraphPojo wholeGraphAroundDefaultCenterVertex();
    SubGraphOperator wholeGraph();
    void removeWholeGraph();
    boolean graphContainsLabel(String label);
    User user();
    void user(User user);
    UserGraph userGraph();
    VertexOperator vertexA();
    void setDefaultVertexAkaVertexA(VertexOperator vertexA);
    VertexOperator vertexB();
    VertexOperator vertexC();
    VertexOperator vertexOfAnotherUser();
    VertexInSubGraphPojo vertexInWholeConnectedGraph(Vertex vertex);
    EdgePojo edgeInWholeGraph(Edge edge);
    void beforeClass();
    void before();
    void after();
    void afterClass();
}
