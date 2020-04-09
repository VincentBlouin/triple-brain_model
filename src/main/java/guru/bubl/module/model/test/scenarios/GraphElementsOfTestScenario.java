/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.test.scenarios;

import guru.bubl.module.model.graph.group_relation.GroupRelationOperator;
import guru.bubl.module.model.graph.vertex.VertexOperator;

public class GraphElementsOfTestScenario {

    private VertexOperator vertexA;
    private VertexOperator vertexB;
    private VertexOperator vertexC;
    private VertexOperator vertexD;
    private VertexOperator vertexE;
    private GroupRelationOperator groupRelation;

    public GraphElementsOfTestScenario(
            VertexOperator vertexA,
            VertexOperator vertexB,
            VertexOperator vertexC,
            VertexOperator vertexD,
            VertexOperator vertexE,
            GroupRelationOperator groupRelation
    ) {
        this.vertexA = vertexA;
        this.vertexB = vertexB;
        this.vertexC = vertexC;
        this.vertexD = vertexD;
        this.vertexE = vertexE;
        this.groupRelation = groupRelation;
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
}
