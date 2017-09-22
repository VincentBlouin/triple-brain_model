/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.content;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.AssistedInject;
import guru.bubl.module.model.center_graph_element.CenterGraphElementOperatorFactory;
import guru.bubl.module.model.graph.FriendlyResourcePojo;
import guru.bubl.module.model.graph.edge.EdgeFactory;
import guru.bubl.module.model.graph.edge.EdgeOperator;
import guru.bubl.module.model.graph.edge.EdgePojo;
import guru.bubl.module.model.graph.identification.IdentifierPojo;
import guru.bubl.module.model.graph.subgraph.UserGraph;
import guru.bubl.module.model.graph.vertex.VertexFactory;
import guru.bubl.module.model.graph.vertex.VertexOperator;

import java.net.URI;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class CommonContent {

    @Inject
    protected VertexFactory vertexFactory;

    @Inject
    protected EdgeFactory edgeFactory;

    @Inject
    CenterGraphElementOperatorFactory centerGraphElementOperatorFactory;

    private ResourceBundle messages;

    @AssistedInject
    protected CommonContent (
            @Assisted Locale locale
    ) {
        messages = PropertyResourceBundle.getBundle(
                CommonContent.class.getCanonicalName() + "ResourceBundle",
                locale
        );
    }

    public void addTwoTasksToVertex(VertexOperator parent){
        EdgePojo task1EdgePojo = parent.addVertexAndRelation();
        EdgeOperator task1Edge = edgeFactory.withUri(
                task1EdgePojo.uri()
        );
        task1Edge.label(messages.getString("task"));
        IdentifierPojo taskTag = task();
        centerGraphElementOperatorFactory.usingFriendlyResource(
                task1Edge.addMeta(taskTag).values().iterator().next()
        ).updateLastCenterDate();
        VertexOperator task1 = vertexFactory.withUri(
                task1EdgePojo.destinationVertex().uri()
        );
        task1.label(messages.getString("task1"));
        EdgePojo task2EdgePojo = parent.addVertexAndRelation();
        EdgeOperator task2Edge = edgeFactory.withUri(
                task2EdgePojo.uri()
        );
        task2Edge.addMeta(taskTag);
        task2Edge.label(messages.getString("task"));
        VertexOperator task2 = vertexFactory.withUri(
                task2EdgePojo.destinationVertex().uri()
        );
        task2.label(messages.getString("task2"));
    }

    private IdentifierPojo task(){
        return new IdentifierPojo(
                URI.create("https://www.wikidata.org/wiki/Q145326551"),
                new FriendlyResourcePojo(
                        messages.getString("task"),
                        messages.getString("taskDesc")
                )
        );
    }
}
