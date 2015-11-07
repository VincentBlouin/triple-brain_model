/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.search;

import guru.bubl.module.model.graph.GraphElementPojo;
import guru.bubl.module.model.graph.GraphElementType;

public class GraphElementSearchResultPojo implements GraphElementSearchResult {
    private GraphElementPojo graphElement;
    private String type;

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
}
