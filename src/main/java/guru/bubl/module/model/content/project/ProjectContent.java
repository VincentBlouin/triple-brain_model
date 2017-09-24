/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.content.project;

import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.AssistedInject;
import guru.bubl.module.model.FriendlyResource;
import guru.bubl.module.model.center_graph_element.CenterGraphElementOperator;
import guru.bubl.module.model.center_graph_element.CenterGraphElementOperatorFactory;
import guru.bubl.module.model.content.CommonContent;
import guru.bubl.module.model.content.CommonContentFactory;
import guru.bubl.module.model.content.Content;
import guru.bubl.module.model.graph.FriendlyResourcePojo;
import guru.bubl.module.model.graph.identification.IdentifierPojo;
import guru.bubl.module.model.graph.subgraph.UserGraph;
import guru.bubl.module.model.graph.vertex.VertexFactory;
import guru.bubl.module.model.graph.vertex.VertexOperator;
import guru.bubl.module.model.search.GraphIndexer;

import javax.inject.Inject;
import java.net.URI;
import java.util.ResourceBundle;

public class ProjectContent implements Content {

    @Inject
    VertexFactory vertexFactory;

    @Inject
    CenterGraphElementOperatorFactory centerGraphElementOperatorFactory;

    private CommonContent commonContent;

    private UserGraph userGraph;
    private VertexOperator center;
    private ResourceBundle messages;

    @AssistedInject
    public ProjectContent (
            @Assisted UserGraph userGraph,
            CommonContentFactory commonContentFactory
    ) {
        this.userGraph = userGraph;
        messages = getResourceBundle();
        commonContent = commonContentFactory.usingLocale(
                getLocale()
        );
    }

    @Override
    public FriendlyResource add() {
        addCenter();
        addStrategy();
        addDefinitionAndVision();
        addHistory();
        addObjectAndInfrastructures();
        addCommunication();
        commonContent.addTwoTasksToVertex(center);
        return center;
    }

    @Override
    public UserGraph getUserGraph() {
        return userGraph;
    }

    private void addCenter(){
        center = vertexFactory.withUri(
                userGraph.createVertex().uri()
        );
        center.label(messages.getString("project"));
        CenterGraphElementOperator centerGraphElementOperator = centerGraphElementOperatorFactory.usingFriendlyResource(
                center
        );
        centerGraphElementOperator.updateLastCenterDate();
    }

    private void addStrategy(){
        VertexOperator strategy = vertexFactory.withUri(
                center.addVertexAndRelation().destinationVertex().uri()
        );
        strategy.label(
                messages.getString("strategy")
        );
        strategy.addMeta(
                new IdentifierPojo(
                        URI.create("https://www.wikidata.org/wiki/Q185451"),
                        new FriendlyResourcePojo(
                                messages.getString("strategy"),
                                messages.getString("strategyDesc")
                        )
                )
        );
    }

    private void addDefinitionAndVision(){
        VertexOperator definitionAndVision = vertexFactory.withUri(
                center.addVertexAndRelation().destinationVertex().uri()
        );
        definitionAndVision.label(
                messages.getString("definitionAndVision")
        );
    }
    private void addHistory(){
        VertexOperator history = vertexFactory.withUri(
                center.addVertexAndRelation().destinationVertex().uri()
        );
        history.label(
                messages.getString("history")
        );
        history.addMeta(
                new IdentifierPojo(
                        URI.create("https://www.wikidata.org/wiki/Q309"),
                        new FriendlyResourcePojo(
                                messages.getString("history"),
                                messages.getString("historyDesc")
                        )
                )
        );
    }
    private void addObjectAndInfrastructures(){
        vertexFactory.withUri(
                center.addVertexAndRelation().destinationVertex().uri()
        ).label(
                messages.getString("objectAndInfrastructure")
        );
    }

    private void addCommunication(){
        vertexFactory.withUri(
                center.addVertexAndRelation().destinationVertex().uri()
        ).label(
                messages.getString("communication")
        );
    }
}
