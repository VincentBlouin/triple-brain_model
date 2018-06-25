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
import guru.bubl.module.model.graph.vertex.VertexInSubGraphOperator;

import java.net.URI;
import java.util.Map;
import java.util.Set;

public interface WholeGraphAdmin {

    default void refreshNumberOfConnectedEdges() {
        Set<VertexInSubGraphOperator> vertices = getWholeGraph().getAllVertices();
        for (VertexInSubGraphOperator vertex : vertices) {
            Map<URI, EdgeOperator> connectedEdges = vertex.connectedEdges();
            vertex.setNumberOfConnectedEdges(
                    connectedEdges.size()
            );
            Integer nbPublic = 0;
            Integer nbFriend = 0;
            for (Edge edge : connectedEdges.values()) {
                ShareLevel shareLevel = edge.getShareLevel();
                if (shareLevel.isPublic()) {
                    nbPublic++;
                }
                if(edge.otherVertex(vertex).getShareLevel() == ShareLevel.FRIENDS){
                    nbFriend++;
                }
            }
            vertex.setNumberOfPublicConnectedEdges(nbPublic);
            vertex.setNbFriendNeighbors(nbFriend);
        }
    }

    default void reAddIdentifications() {
        for (GraphElementOperator operator : getWholeGraph().getAllGraphElements()) {
            try {
                operator.getIdentifications().values().forEach(operator::addMeta);
            } catch (IllegalArgumentException e) {
                //adding self identification causes this exception. No need to add read it, so its ok continue the loop.
            }
        }
    }

    void refreshNumberOfReferencesToAllIdentifications();

    void removeMetasHavingZeroReferences();

    WholeGraph getWholeGraph();

    void reindexAll();

    void reindexAllForUser(User user);
}
