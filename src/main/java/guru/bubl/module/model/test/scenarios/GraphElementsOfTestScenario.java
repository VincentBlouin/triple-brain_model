/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.test.scenarios;

import guru.bubl.module.model.graph.edge.EdgeOperator;
import guru.bubl.module.model.graph.group_relation.GroupRelationOperator;
import guru.bubl.module.model.graph.vertex.VertexOperator;

import java.net.URI;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GraphElementsOfTestScenario {

    /*
     * vertex A{
     *   -edge AB->vertex B{
     *      -edge BC->vertex C{
     *          -to do->{
     *              -edge CD->vertex D,
     *              -edge CE->vertex E
     *          }
     *      }
     *   }
     * }
     * */

    private VertexOperator vertexA, vertexB, vertexC, vertexD, vertexE;
    private GroupRelationOperator groupRelation;
    private EdgeOperator edgeAB, edgeBC, edgeCD, edgeCE;

    public GraphElementsOfTestScenario(
            VertexOperator vertexA,
            VertexOperator vertexB,
            VertexOperator vertexC,
            VertexOperator vertexD,
            VertexOperator vertexE,
            GroupRelationOperator groupRelation,
            EdgeOperator edgeAB,
            EdgeOperator edgeBC,
            EdgeOperator edgeCD,
            EdgeOperator edgeCE
    ) {
        this.vertexA = vertexA;
        this.vertexB = vertexB;
        this.vertexC = vertexC;
        this.vertexD = vertexD;
        this.vertexE = vertexE;
        this.groupRelation = groupRelation;
        this.edgeAB = edgeAB;
        this.edgeBC = edgeBC;
        this.edgeCD = edgeCD;
        this.edgeCE = edgeCE;
    }

    public VertexOperator getVertexA() {
        return vertexA;
    }

    public VertexOperator getVertexB() {
        return vertexB;
    }

    public VertexOperator getVertexC() {
        return vertexC;
    }

    public VertexOperator getVertexD() {
        return vertexD;
    }

    public VertexOperator getVertexE() {
        return vertexE;
    }

    public GroupRelationOperator getGroupRelation() {
        return groupRelation;
    }

    public EdgeOperator getEdgeAB() {
        return edgeAB;
    }

    public EdgeOperator getEdgeBC() {
        return edgeBC;
    }

    public EdgeOperator getEdgeCD() {
        return edgeCD;
    }

    public EdgeOperator getEdgeCE() {
        return edgeCE;
    }

    public Set<URI> allGraphElementsToUris() {
        return Stream.of(
                vertexA.uri(),
                vertexB.uri(),
                vertexC.uri(),
                vertexD.uri(),
                vertexE.uri(),
                groupRelation.uri(),
                edgeAB.uri(),
                edgeBC.uri(),
                edgeCD.uri(),
                edgeCE.uri()
        ).collect(Collectors.toCollection(HashSet::new));
    }
}
