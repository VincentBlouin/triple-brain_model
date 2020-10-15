/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.test;

import guru.bubl.module.model.User;
import guru.bubl.module.model.graph.subgraph.SubGraphPojo;
import guru.bubl.module.model.graph.subgraph.UserGraph;
import guru.bubl.module.model.graph.vertex.VertexOperator;

public interface GraphComponentTest {
    int numberOfEdgesAndVertices();
    SubGraphPojo wholeGraphAroundDefaultCenterVertex();
    default void removeWholeGraph(){
        removeGraphElements();
        removeUsers();
    };
    void removeGraphElements();
    void removeUsers();
    User user();
    void user(User user);
    UserGraph userGraph();
    VertexOperator vertexA();
    void setDefaultVertexAkaVertexA(VertexOperator vertexA);
    VertexOperator vertexB();
    VertexOperator vertexC();
    VertexOperator vertexOfAnotherUser();
    void beforeClass();
    void before();
    void after();
    void afterClass();
}
