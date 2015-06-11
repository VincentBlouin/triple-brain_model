/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.test.scenarios;

import guru.bubl.module.model.graph.vertex.VertexOperator;

public class VerticesCalledABAndC {

    private VertexOperator vertexA;
    private VertexOperator vertexB;
    private VertexOperator vertexC;

    public VerticesCalledABAndC(VertexOperator vertexA, VertexOperator vertexB, VertexOperator vertexC){
        this.vertexA = vertexA;
        this.vertexB = vertexB;
        this.vertexC = vertexC;
    }

    public VertexOperator vertexA(){
        return vertexA;
    }

    public VertexOperator vertexB(){
        return vertexB;
    }

    public VertexOperator vertexC(){
        return vertexC;
    }
}
