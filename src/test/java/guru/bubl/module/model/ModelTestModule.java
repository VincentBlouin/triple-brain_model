/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model;

import com.google.inject.AbstractModule;
import com.sendgrid.Request;
import com.sendgrid.SendGrid;
import guru.bubl.module.common_utils.NoEx;
import guru.bubl.module.model.forgot_password.email.ForgotPasswordEmail;
import guru.bubl.module.model.forgot_password.email.ForgotPasswordEmailImpl;
import guru.bubl.module.model.friend.friend_confirmation_email.FriendConfirmationEmail;
import guru.bubl.module.model.friend.friend_confirmation_email.FriendConfirmationEmailImpl;
import guru.bubl.module.model.friend.friend_request_email.FriendRequestEmail;
import guru.bubl.module.model.friend.friend_request_email.FriendRequestEmailImpl;
import org.codehaus.jettison.json.JSONObject;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

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
        ).thenAnswer(new Answer<String>() {
            @Override
            public String answer(InvocationOnMock invocation) throws Throwable {
                Object[] args = invocation.getArguments();
                Request request = (Request) args[0];
                String body = request.getBody();
                System.out.println(body);
                return null;
            }
        })).get();
        bind(
                SendGrid.class
        ).toInstance(
                doNothingSendGrid
        );
    }
}
