/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.admin;

import guru.bubl.module.model.User;
import guru.bubl.module.model.WholeGraph;
import guru.bubl.module.model.graph.GraphElementOperator;
import guru.bubl.module.model.graph.ShareLevel;
import guru.bubl.module.model.graph.edge.Edge;
import guru.bubl.module.model.graph.edge.EdgeOperator;
import guru.bubl.module.model.graph.vertex.NbNeighbors;
import guru.bubl.module.model.graph.vertex.VertexInSubGraphOperator;

import java.net.URI;
import java.util.Map;
import java.util.Set;

public interface WholeGraphAdmin {

    default void refreshNbNeighbors() {
        Set<VertexInSubGraphOperator> vertices = getWholeGraph().getAllVertices();
        for (VertexInSubGraphOperator vertex : vertices) {
            Map<URI, EdgeOperator> connectedEdges = vertex.connectedEdges();
            Integer nbPrivate = 0;
            Integer nbPublic = 0;
            Integer nbFriend = 0;
            for (Edge edge : connectedEdges.values()) {
                ShareLevel shareLevel = edge.otherVertex(vertex).getShareLevel();
                if (shareLevel.isPublic()) {
                    nbPublic++;
                } else if (shareLevel == ShareLevel.FRIENDS) {
                    nbFriend++;
                } else {
                    nbPrivate++;
                }
            }
            NbNeighbors nbNeighbors = vertex.getNbNeighbors();
            nbNeighbors.setPrivate(nbPrivate);
            nbNeighbors.setFriend(nbFriend);
            nbNeighbors.setPublic(nbPublic);
        }
    }

    default void reAddIdentifications() {
        for (GraphElementOperator operator : getWholeGraph().getAllGraphElements()) {
            try {
                operator.getTags().values().forEach(operator::addTag);
            } catch (IllegalArgumentException e) {
                //adding self identification causes this exception. No need to add read it, so its ok continue the loop.
            }
        }
    }

    void refreshNbNeighborsToAllTags();

    void removeMetasHavingZeroReferences();

    WholeGraph getWholeGraph();

    void reindexAll();

    void reindexAllForUser(User user);
}
