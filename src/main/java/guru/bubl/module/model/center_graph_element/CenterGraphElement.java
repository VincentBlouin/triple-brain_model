/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.center_graph_element;

import guru.bubl.module.model.graph.GraphElement;
import guru.bubl.module.model.graph.ShareLevel;
import guru.bubl.module.model.graph.vertex.NbNeighbors;

import java.net.URI;
import java.util.Date;
import java.util.Map;

public interface CenterGraphElement {
    Integer getNumberOfVisits();

    GraphElement getGraphElement();

    Date getLastCenterDate();

    Map<URI, String> getContext();

    NbNeighbors getNbNeighbors();

    ShareLevel getShareLevel();

    Boolean isPattern();
}
