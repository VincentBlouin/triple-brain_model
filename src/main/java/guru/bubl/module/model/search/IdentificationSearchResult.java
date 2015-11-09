/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.search;

import guru.bubl.module.model.graph.GraphElementPojo;

public class IdentificationSearchResult implements GraphElementSearchResult {

    private GraphElementPojo graphElement;
    private Integer nbReferences;
    private String type;


    public IdentificationSearchResult(
            GraphElementPojo graphElement,
            String type,
            Integer nbReferences
    ){
        this.graphElement = graphElement;
        this.type = type;
        this.nbReferences = nbReferences;
    }

    @Override
    public GraphElementSearchResultPojo getGraphElementSearchResult() {
        return new GraphElementSearchResultPojo(
                graphElement,
                type
        );
    }

    @Override
    public GraphElementPojo getGraphElement() {
        return graphElement;
    }

    @Override
    public String getType() {
        return type;
    }

    public Integer getNbReferences(){
        return nbReferences;
    }
}
