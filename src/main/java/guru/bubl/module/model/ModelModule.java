/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model;

import com.google.inject.AbstractModule;
import com.sendgrid.Mail;
import com.sendgrid.SendGrid;
import com.sun.mail.iap.Response;
import guru.bubl.module.common_utils.NoExRun;
import guru.bubl.module.model.forgot_password.email.ForgotPasswordEmailImpl;
import guru.bubl.module.model.forgot_password.email.ForgotPasswordEmail;

import javax.inject.Singleton;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

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
