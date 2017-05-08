/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.search;

import com.google.common.collect.ImmutableMap;
import guru.bubl.module.model.graph.GraphElementPojo;
import guru.bubl.module.model.graph.GraphElementType;
import guru.bubl.module.model.graph.identification.IdentifierPojo;

public class IdentifierSearchResult implements GraphElementSearchResult {

    private IdentifierPojo identifierPojo;
    private final GraphElementType type = GraphElementType.meta;

    public IdentifierSearchResult(
            IdentifierPojo identifierPojo
    ) {
        this.identifierPojo = identifierPojo;
    }

    @Override
    public GraphElementSearchResultPojo getGraphElementSearchResult() {
        return new GraphElementSearchResultPojo(
                getGraphElement(),
                type
        );
    }

    @Override
    public GraphElementPojo getGraphElement() {
        return new GraphElementPojo(
                identifierPojo.getFriendlyResource(),
                ImmutableMap.of(
                        identifierPojo.getExternalResourceUri(),
                        identifierPojo
                )
        );
    }

    @Override
    public GraphElementType getType() {
        return type;
    }

    public IdentifierPojo getIdentifierPojo(){
        return identifierPojo;
    }
}
