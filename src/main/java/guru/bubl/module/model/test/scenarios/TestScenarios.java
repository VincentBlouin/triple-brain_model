/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.test.scenarios;

import guru.bubl.module.model.User;
import guru.bubl.module.model.graph.vertex.VertexFactory;
import guru.bubl.module.model.graph.vertex.VertexOperator;
import guru.bubl.module.model.test.GraphComponentTest;
import guru.bubl.module.model.graph.GraphFactory;
import guru.bubl.module.model.graph.UserGraph;
import guru.bubl.module.model.graph.edge.EdgeOperator;

import javax.inject.Inject;

public class TestScenarios {

    @Inject
    protected GraphFactory graphFactory;

    @Inject
    protected VertexFactory vertexFactory;

    @Inject
    protected GraphComponentTest graphComponentTest;

    public VerticesCalledABAndC makeGraphHave3VerticesABCWhereAIsDefaultCenterVertexAndAPointsToBAndBPointsToC(UserGraph userGraph) {
        graphComponentTest.removeWholeGraph();
        graphFactory.createForUser(userGraph.user());
        VertexOperator vertexA = userGraph.defaultVertex();
        vertexA.label("vertex A");
        VertexOperator vertexB = vertexA.addVertexAndRelation().destinationVertex();
        vertexB.label("vertex B");
        VertexOperator vertexC = vertexB.addVertexAndRelation().destinationVertex();
        vertexC.label("vertex C");
        EdgeOperator betweenAAndB = vertexA.getEdgeThatLinksToDestinationVertex(vertexB);
        betweenAAndB.label("between vertex A and vertex B");
        EdgeOperator betweenBAndC = vertexB.getEdgeThatLinksToDestinationVertex(vertexC);
        betweenBAndC.label("between vertex B and vertex C");
        return new VerticesCalledABAndC(
                vertexA,
                vertexB,
                vertexC
        );
    }

    public VerticesCalledABAndC makeGraphHave3SerialVerticesWithLongLabels(UserGraph userGraph) throws Exception {
        VerticesCalledABAndC verticesCalledABAndC = makeGraphHave3VerticesABCWhereAIsDefaultCenterVertexAndAPointsToBAndBPointsToC(
                userGraph
        );
        verticesCalledABAndC.vertexA().label("vertex Azure");
        verticesCalledABAndC.vertexB().label("vertex Bareau");
        verticesCalledABAndC.vertexC().label("vertex Cadeau");
        return verticesCalledABAndC;
    }

    public VertexOperator addPineAppleVertexToVertex(VertexOperator vertex) {
        EdgeOperator newEdge = vertex.addVertexAndRelation();
        VertexOperator pineApple = newEdge.destinationVertex();
        pineApple.label("pine Apple");
        return pineApple;
    }

    public VertexOperator createAVertex(User user){
        UserGraph userGraph = graphFactory.createForUser(
                user
        );
        return vertexFactory.createForOwnerUsername(
                userGraph.user().username()
        );
    }
}
