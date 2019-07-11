/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.content.procedure;

import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.AssistedInject;
import guru.bubl.module.model.FriendlyResource;
import guru.bubl.module.model.center_graph_element.CenterGraphElementOperatorFactory;
import guru.bubl.module.model.content.Content;
import guru.bubl.module.model.graph.FriendlyResourcePojo;
import guru.bubl.module.model.graph.edge.EdgeFactory;
import guru.bubl.module.model.graph.edge.EdgeOperator;
import guru.bubl.module.model.graph.edge.EdgePojo;
import guru.bubl.module.model.graph.identification.IdentifierPojo;
import guru.bubl.module.model.graph.subgraph.UserGraph;
import guru.bubl.module.model.graph.vertex.VertexFactory;
import guru.bubl.module.model.graph.vertex.VertexOperator;

import javax.inject.Inject;
import java.net.URI;
import java.util.ResourceBundle;

public class ProcedureContent implements Content {

    @Inject
    VertexFactory vertexFactory;

    @Inject
    EdgeFactory edgeFactory;

    @Inject
    CenterGraphElementOperatorFactory centerGraphElementOperatorFactory;

    private UserGraph userGraph;

    private ResourceBundle messages;

    private VertexOperator center;

    @AssistedInject
    public ProcedureContent(
            @Assisted UserGraph userGraph
    ) {
        this.userGraph = userGraph;
        messages = getResourceBundle();
    }

    @Override
    public FriendlyResource add() {
        addCenter();
        addObjects();
        addSteps();
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
        center.label(messages.getString("procedure_x"));
        center.addMeta(
                new IdentifierPojo(
                        URI.create("https://www.wikidata.org/wiki/Q28520605"),
                        new FriendlyResourcePojo(
                                messages.getString("procedure"),
                                messages.getString("procedureDesc")
                        )
                )
        );
        centerGraphElementOperatorFactory.usingFriendlyResource(
                center
        ).updateLastCenterDate();
    }
    private void addObjects(){
        EdgePojo edge1Pojo = center.addVertexAndRelation();
        EdgeOperator object1Relation = edgeFactory.withUri(
                edge1Pojo.uri()
        );
        VertexOperator object1Vertex = vertexFactory.withUri(
                object1Relation.destinationVertex().uri()
        );
        object1Vertex.label(messages.getString("thing1"));

        EdgeOperator object2Relation = edgeFactory.withUri(
                center.addVertexAndRelation().uri()
        );
        object2Relation.addMeta(
                new IdentifierPojo(
                        object1Relation.uri(),
                        new FriendlyResourcePojo(
                                messages.getString("things")
                        )
                )
        );
        VertexOperator object2Vertex = vertexFactory.withUri(
                object2Relation.destinationVertex().uri()
        );
        object2Vertex.label(messages.getString("thing2"));
    }

    private void addSteps(){
        EdgePojo edge1Pojo = center.addVertexAndRelation();
        EdgeOperator step1Relation = edgeFactory.withUri(
                edge1Pojo.uri()
        );
        VertexOperator step1Vertex = vertexFactory.withUri(
                step1Relation.destinationVertex().uri()
        );
        step1Vertex.label(messages.getString("step1"));

        EdgeOperator step2Relation = edgeFactory.withUri(
                center.addVertexAndRelation().uri()
        );
        step2Relation.addMeta(
                new IdentifierPojo(
                        step1Relation.uri(),
                        new FriendlyResourcePojo(
                                messages.getString("step")
                        )
                )
        );
        VertexOperator step2Vertex = vertexFactory.withUri(
                step2Relation.destinationVertex().uri()
        );
        step2Vertex.label(messages.getString("step2"));
    }
}
