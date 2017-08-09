/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.center_graph_element;

import guru.bubl.module.model.graph.GraphElement;
import guru.bubl.module.model.graph.GraphElementPojo;

import java.net.URI;
import java.util.Date;
import java.util.Map;

public class CenterGraphElementPojo implements CenterGraphElement {
    private Integer numberOfVisits;

    private GraphElementPojo graphElement;
    private Date lastCenterDate;
    private Map<URI, String> context;
    private Integer nbReferences;

    public CenterGraphElementPojo(
            Integer numberOfVisits,
            Date lastCenterDate,
            GraphElementPojo graphElement,
            Map<URI, String> context,
            Integer nbReferences
    ) {
        this.numberOfVisits = numberOfVisits;
        this.graphElement = graphElement;
        this.lastCenterDate = lastCenterDate;
        this.context = context;
        this.nbReferences = nbReferences;
    }

    public CenterGraphElementPojo(
            URI uri
    ) {
        this.graphElement = new GraphElementPojo(
                uri
        );
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

    @Override
    public Map<URI, String> getContext() {
        return context;
    }

    @Override
    public Integer getNbReferences() {
        return nbReferences;
    }

}
