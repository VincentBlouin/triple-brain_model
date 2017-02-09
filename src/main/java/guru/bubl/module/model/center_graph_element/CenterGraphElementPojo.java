/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.center_graph_element;

import guru.bubl.module.model.graph.GraphElement;
import guru.bubl.module.model.graph.GraphElementPojo;

import java.util.Date;

public class CenterGraphElementPojo implements CenterGraphElement{
    private Integer numberOfVisits;
    private GraphElementPojo graphElement;
    private Date lastCenterDate;

    public CenterGraphElementPojo(
            Integer numberOfVisits,
            Date lastCenterDate,
            GraphElementPojo graphElement
    ){
        this.numberOfVisits = numberOfVisits;
        this.graphElement = graphElement;
        this.lastCenterDate = lastCenterDate;
    }

    @Override
    public Integer getNumberOfVisits() {
        return numberOfVisits;
    }

    @Override
    public GraphElement getGraphElement() {
        return graphElement;
    }

    @Override
    public Date getLastCenterDate() {
        return lastCenterDate;
    }
}
