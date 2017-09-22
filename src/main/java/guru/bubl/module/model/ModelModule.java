/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model;

import com.google.inject.AbstractModule;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import com.sendgrid.SendGrid;
import guru.bubl.module.common_utils.NoExRun;
import guru.bubl.module.model.content.AllContentFactory;
import guru.bubl.module.model.content.CommonContent;
import guru.bubl.module.model.content.CommonContentFactory;
import guru.bubl.module.model.content.evaluation.EvaluationContentFactory;
import guru.bubl.module.model.content.movie.MovieContentFactory;
import guru.bubl.module.model.content.procedure.ProcedureContentFactory;
import guru.bubl.module.model.content.project.ProjectContent;
import guru.bubl.module.model.content.project.ProjectContentFactory;
import guru.bubl.module.model.forgot_password.email.ForgotPasswordEmail;
import guru.bubl.module.model.forgot_password.email.ForgotPasswordEmailImpl;

import javax.inject.Singleton;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
public class ModelModule extends AbstractModule {

    private Boolean isTesting;
    private String sendGridKey;

    public static ModelModule forTesting() {
        return new ModelModule(
                true
        );
    }

    public ModelModule(String sendGridKey) {

        this(false);
        this.sendGridKey = sendGridKey;
    }

    private ModelModule(Boolean isTesting) {
        this.isTesting = isTesting;
    }

    @Override
    protected void configure() {
        FactoryModuleBuilder factoryModuleBuilder = new FactoryModuleBuilder();
        install(factoryModuleBuilder
                .build(ProjectContentFactory.class));
        install(factoryModuleBuilder
                .build(AllContentFactory.class));
        install(factoryModuleBuilder
                .build(CommonContentFactory.class));
        install(factoryModuleBuilder
                .build(EvaluationContentFactory.class));
        install(factoryModuleBuilder
                .build(MovieContentFactory.class));
        install(factoryModuleBuilder
                .build(ProcedureContentFactory.class));
        if (isTesting) {
            testBinding();
        } else {
            nonTestBinding();
        }
    }

    private void testBinding() {
        SendGrid doNothingSendGrid = mock(SendGrid.class);
        NoExRun.wrap(() -> when(
                doNothingSendGrid.api(
                        any()
                )
        ).thenReturn(null)).get();
        bind(
                SendGrid.class
        ).toInstance(
                doNothingSendGrid
        );
        bind(ForgotPasswordEmail.class).to(ForgotPasswordEmailImpl.class).in(Singleton.class);
    }

    private void nonTestBinding() {
        bind(SendGrid.class).toInstance(new SendGrid(sendGridKey));
        bind(ForgotPasswordEmail.class).to(ForgotPasswordEmailImpl.class).in(Singleton.class);
    }
}
