/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.search;

import guru.bubl.module.model.graph.GraphElementPojo;

import java.net.URI;

public class IdentificationSearchResult implements GraphElementSearchResult {

    private GraphElementPojo graphElement;
    private Integer nbReferences;
    private String type;
    private URI externalUri;


    public IdentificationSearchResult(
            GraphElementPojo graphElement,
            String type,
            URI externalUri,
            Integer nbReferences
    ){
        this.graphElement = graphElement;
        this.type = type;
        this.externalUri = externalUri;
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

    public URI getExternalUri(){
        return this.externalUri;
    }
}
