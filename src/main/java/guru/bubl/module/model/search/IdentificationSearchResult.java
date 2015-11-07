/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.search;

import guru.bubl.module.model.graph.GraphElementPojo;

import java.net.URI;
import java.util.Map;

public class IdentificationSearchResult implements GraphElementSearchResult {

    private GraphElementPojo graphElement;
    private Map<URI, GraphElementPojo> identifiedTo;
    private String type;


    public IdentificationSearchResult(
            GraphElementPojo graphElement,
            String type,
            Map<URI, GraphElementPojo> identifiedTo
    ){
        this.graphElement = graphElement;
        this.type = type;
        this.identifiedTo = identifiedTo;
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

    public Map<URI, GraphElementPojo> getIdentifiedTo(){
        return identifiedTo;
    }
}
