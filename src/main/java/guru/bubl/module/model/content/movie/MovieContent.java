/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.content.movie;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.AssistedInject;
import guru.bubl.module.model.FriendlyResource;
import guru.bubl.module.model.center_graph_element.CenterGraphElementOperatorFactory;
import guru.bubl.module.model.content.Content;
import guru.bubl.module.model.graph.subgraph.UserGraph;
import guru.bubl.module.model.graph.vertex.VertexFactory;
import guru.bubl.module.model.graph.vertex.VertexOperator;

import java.util.ResourceBundle;

public class MovieContent implements Content {

    @Inject
    VertexFactory vertexFactory;

    @Inject
    CenterGraphElementOperatorFactory centerGraphElementOperatorFactory;

    private UserGraph userGraph;

    private ResourceBundle messages;

    @AssistedInject
    public MovieContent(
            @Assisted UserGraph userGraph
    ) {
        this.userGraph = userGraph;
        messages = getResourceBundle();
    }

    @Override
    public FriendlyResource add() {
        VertexOperator center = vertexFactory.withUri(
                userGraph.createVertex().uri()
        );
        center.label(
                messages.getString("movie")
        );
        centerGraphElementOperatorFactory.usingFriendlyResource(
                center
        ).updateLastCenterDate();
        return center;
    }

    @Override
    public UserGraph getUserGraph() {
        return userGraph;
    }
}
