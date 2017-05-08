/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.search;

import guru.bubl.module.model.graph.GraphElement;
import guru.bubl.module.model.graph.GraphElementPojo;
import guru.bubl.module.model.graph.GraphElementType;

public class GraphElementSearchResultPojo implements GraphElementSearchResult {
    private GraphElementPojo graphElement;
    private GraphElementType type;
    private Integer nbReferences = 0;
    private Integer nbVisits;

    public GraphElementSearchResultPojo(
            GraphElementPojo graphElement,
            GraphElementType type
    ) {
        this.graphElement = graphElement;
        this.type = type;
    }

    @Override
    public GraphElementSearchResultPojo getGraphElementSearchResult() {
        return this;
    }

    @Override
    public GraphElementPojo getGraphElement() {
        return graphElement;
    }

    public void setNbReferences(Integer nbReferences){
        this.nbReferences = nbReferences;
    }

    @Override
    public GraphElementType getType() {
        return type;
    }

    public Integer getNbReferences(){
        return nbReferences;
    }

    public void setNbVisits(Integer nbVisits){
        this.nbVisits = nbVisits;
    }

    public Integer getNbVisits(){
        return this.nbVisits;
    }
}
