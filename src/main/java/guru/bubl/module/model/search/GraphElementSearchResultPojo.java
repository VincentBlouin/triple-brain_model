/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.search;

import guru.bubl.module.model.graph.GraphElementPojo;
import guru.bubl.module.model.graph.GraphElementType;

public class GraphElementSearchResultPojo implements GraphElementSearchResult {
    private GraphElementPojo graphElement;
    private String type;
    private Integer nbReferences = 0;

    public GraphElementSearchResultPojo(
            GraphElementPojo graphElement,
            GraphElementType type
    ) {
        this(
                graphElement,
                type.name()
        );
    }

    public GraphElementSearchResultPojo(
            GraphElementPojo graphElement,
            String type
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

    @Override
    public String getType() {
        return type;
    }

    public void setNbReferences(Integer nbReferences){
        this.nbReferences = nbReferences;
    }

    public Integer getNbReferences(){
        return nbReferences;
    }
}
