/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.test.scenarios;

import guru.bubl.module.model.User;
import guru.bubl.module.model.graph.*;
import guru.bubl.module.model.graph.GraphFactory;
import guru.bubl.module.model.graph.edge.Edge;
import guru.bubl.module.model.graph.subgraph.UserGraph;
import guru.bubl.module.model.graph.tag.TagPojo;
import guru.bubl.module.model.graph.vertex.VertexFactory;
import guru.bubl.module.model.graph.vertex.VertexOperator;
import guru.bubl.module.model.suggestion.Suggestion;
import guru.bubl.module.model.suggestion.SuggestionPojo;
import guru.bubl.module.model.test.GraphComponentTest;
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

    public static TagPojo identificationFromFriendlyResource(GraphElementOperator resource) {
        return new TagPojo(
                resource.uri(),
                new GraphElementPojo(resource)
        );
    }

    public static SuggestionPojo suggestionFromComparisonForUserAndTriple(
            User user,
            Triple triple
    ) {

        return SuggestionPojo.forSameAsTypeOriginAndOwner(
                new FriendlyResourcePojo(
                        triple.getEdge().uri(),
                        triple.getEdge().label()
                ),
                new FriendlyResourcePojo(
                        triple.getDestination().uri(),
                        triple.getDestination().label()
                ),
                Suggestion.COMPARISON_PREFIX + triple.getSource().uri(),
                user
        );
    }
}
