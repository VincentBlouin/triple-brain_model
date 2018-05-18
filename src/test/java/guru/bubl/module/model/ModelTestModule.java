/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model;

import com.google.inject.AbstractModule;
import com.sendgrid.SendGrid;
import guru.bubl.module.common_utils.NoEx;
import guru.bubl.module.model.forgot_password.email.ForgotPasswordEmail;
import guru.bubl.module.model.forgot_password.email.ForgotPasswordEmailImpl;

import javax.inject.Singleton;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ModelTestModule extends AbstractModule {

    @Override
    protected void configure() {
        SendGrid doNothingSendGrid = mock(SendGrid.class);
        NoEx.wrap(() -> when(
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
}
