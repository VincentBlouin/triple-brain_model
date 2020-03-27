/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.search;

import guru.bubl.module.model.graph.GraphElementPojo;
import guru.bubl.module.model.graph.GraphElementType;
import guru.bubl.module.model.graph.ShareLevel;
import guru.bubl.module.model.graph.vertex.NbNeighbors;
import guru.bubl.module.model.graph.vertex.NbNeighborsPojo;

import java.net.URI;
import java.util.Map;

public interface GraphElementSearchResult {
    GraphElementPojo getGraphElement();

    GraphElementType getType();

    String getContext();

    GraphElementSearchResultPojo getGraphElementSearchResult();

    Integer getNbVisits();

    NbNeighborsPojo getNbNeighbors();

    ShareLevel getShareLevel();

    Boolean isPattern();
}
