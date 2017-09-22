/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.content;

import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.AssistedInject;
import guru.bubl.module.model.FriendlyResource;
import guru.bubl.module.model.admin.WholeGraphAdmin;
import guru.bubl.module.model.content.evaluation.EvaluationContent;
import guru.bubl.module.model.content.evaluation.EvaluationContentFactory;
import guru.bubl.module.model.content.movie.MovieContentFactory;
import guru.bubl.module.model.content.procedure.ProcedureContent;
import guru.bubl.module.model.content.procedure.ProcedureContentFactory;
import guru.bubl.module.model.content.project.ProjectContentFactory;
import guru.bubl.module.model.graph.subgraph.UserGraph;
import guru.bubl.module.model.graph.vertex.VertexFactory;

import javax.inject.Inject;

public class AllContent implements Content {

    @Inject
    ProjectContentFactory projectContentFactory;

    @Inject
    EvaluationContentFactory evaluationContentFactory;

    @Inject
    MovieContentFactory movieContentFactory;

    @Inject
    ProcedureContentFactory procedureContentFactory;

    @Inject
    WholeGraphAdmin wholeGraphAdmin;

    private UserGraph userGraph;

    @AssistedInject
    public AllContent (
            @Assisted UserGraph userGraph
    ) {
        this.userGraph = userGraph;
    }

    @Override
    public FriendlyResource add()
    {
        movieContentFactory.forUserGraph(userGraph).add();
        evaluationContentFactory.forUserGraph(userGraph).add();
        procedureContentFactory.forUserGraph(userGraph).add();
        FriendlyResource result = projectContentFactory.forUserGraph(userGraph).add();
        wholeGraphAdmin.reindexAllForUser(userGraph.user());
        return result;
    }

    @Override
    public UserGraph getUserGraph() {
        return userGraph;
    }
}
