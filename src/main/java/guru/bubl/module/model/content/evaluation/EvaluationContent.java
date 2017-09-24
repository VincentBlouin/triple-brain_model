/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.content.evaluation;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.AssistedInject;
import guru.bubl.module.model.FriendlyResource;
import guru.bubl.module.model.center_graph_element.CenterGraphElementOperatorFactory;
import guru.bubl.module.model.content.CommonContent;
import guru.bubl.module.model.content.CommonContentFactory;
import guru.bubl.module.model.content.Content;
import guru.bubl.module.model.graph.FriendlyResourcePojo;
import guru.bubl.module.model.graph.identification.IdentifierPojo;
import guru.bubl.module.model.graph.subgraph.UserGraph;
import guru.bubl.module.model.graph.vertex.VertexFactory;
import guru.bubl.module.model.graph.vertex.VertexOperator;

import java.net.URI;
import java.util.ResourceBundle;

public class EvaluationContent implements Content {

    @Inject
    VertexFactory vertexFactory;

    @Inject
    CenterGraphElementOperatorFactory centerGraphElementOperatorFactory;

    CommonContent commonContent;

    private UserGraph userGraph;
    private ResourceBundle messages;
    private VertexOperator center;

    @AssistedInject
    public EvaluationContent (
            @Assisted UserGraph userGraph,
            CommonContentFactory commonContentFactory
    ) {
        this.userGraph = userGraph;
        messages = getResourceBundle();
        commonContent = commonContentFactory.usingLocale(getLocale());
    }

    @Override
    public FriendlyResource add() {
        addCenter();
        commonContent.addGroupRelationWithTwoVertices(
                center,
                messages.getString("advantage")
        );
        commonContent.addGroupRelationWithTwoVertices(
                center,
                messages.getString("opportunity")
        );
        commonContent.addGroupRelationWithTwoVertices(
                center,
                messages.getString("risk")
        );
        commonContent.addGroupRelationWithTwoVertices(
                center,
                messages.getString("disadvantage")
        );
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
        center.label(messages.getString("evaluation"));
        center.addMeta(
                new IdentifierPojo(
                        URI.create("https://www.wikidata.org/wiki/Q175096"),
                        new FriendlyResourcePojo(
                                messages.getString("swot"),
                                messages.getString("swotDesc")
                        )
                )
        );
        centerGraphElementOperatorFactory.usingFriendlyResource(
                center
        ).updateLastCenterDate();
    }
}
