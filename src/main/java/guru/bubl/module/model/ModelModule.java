/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model;

import com.google.inject.AbstractModule;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import com.sendgrid.SendGrid;
import guru.bubl.module.model.forgot_password.email.ForgotPasswordEmail;
import guru.bubl.module.model.forgot_password.email.ForgotPasswordEmailImpl;
import guru.bubl.module.model.friend.friend_confirmation_email.FriendConfirmationEmail;
import guru.bubl.module.model.friend.friend_confirmation_email.FriendConfirmationEmailImpl;
import guru.bubl.module.model.friend.friend_request_email.FriendRequestEmail;
import guru.bubl.module.model.friend.friend_request_email.FriendRequestEmailImpl;

import javax.inject.Singleton;

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
        bind(EmailMindRespect.class);
        bind(ForgotPasswordEmail.class).to(ForgotPasswordEmailImpl.class).in(Singleton.class);
        bind(FriendRequestEmail.class).to(FriendRequestEmailImpl.class).in(Singleton.class);
        bind(FriendConfirmationEmail.class).to(FriendConfirmationEmailImpl.class).in(Singleton.class);
        if (!isTesting) {
            nonTestBinding();
        }
    }

    private void nonTestBinding() {
        bind(SendGrid.class).toInstance(new SendGrid(sendGridKey));
    }
}
