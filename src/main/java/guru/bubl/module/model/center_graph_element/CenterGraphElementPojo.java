/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.center_graph_element;

import guru.bubl.module.model.graph.GraphElement;
import guru.bubl.module.model.graph.GraphElementPojo;

public class CenterGraphElementPojo implements CenterGraphElement{
    private Integer numberOfVisits;
    private GraphElementPojo graphElement;

    public CenterGraphElementPojo(
            Integer numberOfVisits,
            GraphElementPojo graphElement
    ){
        this.numberOfVisits = numberOfVisits;
        this.graphElement = graphElement;
    }

    @Override
    public Integer getNumberOfVisits() {
        return numberOfVisits;
    }

    @Override
    public GraphElement getGraphElement() {
        return graphElement;
    }
}
