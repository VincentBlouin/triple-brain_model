/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.search;

import guru.bubl.module.model.graph.GraphElementPojo;
import guru.bubl.module.model.graph.GraphElementType;
import guru.bubl.module.model.graph.edge.EdgePojo;

public class EdgeSearchResult implements GraphElementSearchResult {

    private EdgePojo edge;
    private final GraphElementType type = GraphElementType.edge;
    private Integer nbReferences = 0;

    public EdgeSearchResult(
            EdgePojo edgePojo
    ){
        this.edge = edgePojo;
    }

    @Override
    public GraphElementSearchResultPojo getGraphElementSearchResult() {
        return new GraphElementSearchResultPojo(
                edge.getGraphElement(),
                type
        );
    }

    @Override
    public GraphElementPojo getGraphElement() {
        return edge.getGraphElement();
    }

    @Override
    public GraphElementType getType() {
        return type;
    }

    public EdgePojo getEdge(){
        return edge;
    }

    public void setNbReferences(Integer nbReferences){
        this.nbReferences = nbReferences;
    }

    public Integer getNbReferences(){
        return nbReferences;
    }
}
