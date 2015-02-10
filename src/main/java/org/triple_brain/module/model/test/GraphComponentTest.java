/*
 * Copyright Vincent Blouin under the Mozilla Public License 1.1
 */

package org.triple_brain.module.model.test;

import org.triple_brain.module.model.User;
import org.triple_brain.module.model.graph.SubGraphPojo;
import org.triple_brain.module.model.graph.UserGraph;
import org.triple_brain.module.model.graph.edge.Edge;
import org.triple_brain.module.model.graph.edge.EdgePojo;
import org.triple_brain.module.model.graph.vertex.Vertex;
import org.triple_brain.module.model.graph.vertex.VertexInSubGraphPojo;
import org.triple_brain.module.model.graph.vertex.VertexOperator;

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
