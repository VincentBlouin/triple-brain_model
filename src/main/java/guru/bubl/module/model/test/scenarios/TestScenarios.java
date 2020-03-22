/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.test.scenarios;

import guru.bubl.module.model.graph.FriendlyResourcePojo;
import guru.bubl.module.model.graph.GraphElementOperator;
import guru.bubl.module.model.graph.GraphElementPojo;
import guru.bubl.module.model.graph.GraphFactory;
import guru.bubl.module.model.graph.edge.Edge;
import guru.bubl.module.model.graph.edge.EdgeOperator;
import guru.bubl.module.model.graph.subgraph.UserGraph;
import guru.bubl.module.model.graph.tag.TagPojo;
import guru.bubl.module.model.graph.vertex.VertexFactory;
import guru.bubl.module.model.graph.vertex.VertexOperator;
import guru.bubl.module.model.test.GraphComponentTest;

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
        VertexOperator vertexA = vertexFactory.withUri(
                userGraph.createVertex().uri()
        );
        vertexA.label("vertex A");
        VertexOperator vertexB = vertexFactory.withUri(
                vertexA.addVertexAndRelation().destinationVertex().uri()
        );
        vertexB.label("vertex B");
        VertexOperator vertexC = vertexFactory.withUri(
                vertexB.addVertexAndRelation().destinationVertex().uri()
        );
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
        Edge newEdge = vertex.addVertexAndRelation();
        VertexOperator pineApple = vertexFactory.withUri(
                newEdge.destinationVertex().uri()
        );
        pineApple.label("pine Apple");
        return pineApple;
    }

    public static TagPojo tagFromFriendlyResource(GraphElementOperator resource) {
        FriendlyResourcePojo friendlyResourcePojo = new FriendlyResourcePojo(
                resource.label(),
                resource.comment()
        );
        friendlyResourcePojo.setImages(resource.images());
        return new TagPojo(
                resource.uri(),
                new GraphElementPojo(
                        friendlyResourcePojo
                )
        );
    }
}
