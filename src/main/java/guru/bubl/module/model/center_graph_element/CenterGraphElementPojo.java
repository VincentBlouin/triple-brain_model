/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.center_graph_element;

import guru.bubl.module.model.graph.graph_element.GraphElement;
import guru.bubl.module.model.graph.graph_element.GraphElementPojo;
import guru.bubl.module.model.graph.ShareLevel;
import guru.bubl.module.model.graph.fork.NbNeighbors;
import guru.bubl.module.model.graph.fork.NbNeighborsPojo;

import java.net.URI;
import java.util.Date;

public class CenterGraphElementPojo implements CenterGraphElement {
    private Integer numberOfVisits;

    private GraphElementPojo graphElement;
    private Date lastCenterDate;
    private String context;
    private ShareLevel shareLevel;
    private Boolean isPattern;
    private NbNeighborsPojo nbNeighbors;

    public CenterGraphElementPojo(
            Integer numberOfVisits,
            Date lastCenterDate,
            GraphElementPojo graphElement,
            String context,
            ShareLevel shareLevel,
            Boolean isPattern,
            NbNeighborsPojo nbNeighbors
    ) {
        this.numberOfVisits = numberOfVisits;
        this.graphElement = graphElement;
        this.lastCenterDate = lastCenterDate;
        this.context = context;
        this.shareLevel = shareLevel;
        this.isPattern = isPattern;
        this.nbNeighbors = nbNeighbors;
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
    public String getContext() {
        return context;
    }

    @Override
    public NbNeighbors getNbNeighbors() {
        return nbNeighbors;
    }

    @Override
    public ShareLevel getShareLevel() {
        return shareLevel;
    }

    @Override
    public Boolean isPattern() {
        return isPattern;
    }

}
