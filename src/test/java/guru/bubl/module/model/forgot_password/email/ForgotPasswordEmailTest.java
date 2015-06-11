/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.forgot_password.email;

import org.codehaus.jettison.json.JSONArray;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import guru.bubl.module.model.User;

import javax.mail.Message;
import javax.mail.Transport;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.powermock.api.support.membermodification.MemberMatcher.method;
import static org.powermock.api.support.membermodification.MemberModifier.suppress;

@RunWith(PowerMockRunner.class)
@PrepareForTest(javax.mail.Transport.class)
public class ForgotPasswordEmailTest {

    @Before
    public void before() throws Exception {
        suppress(method(Transport.class, "send", Message.class));
    }

    @Test
    public void sent_to_correct_recipient() throws Exception {
        Message msg = new ForgotPasswordEmailImpl().send(
                user(),
                ""
        );
        assertThat(
                msg.getAllRecipients()[0].toString(),
                is("test@example.org")
        );
    }

    @Test
    public void has_correct_from() throws Exception {
        Message msg = new ForgotPasswordEmailImpl().send(
                user(),
                ""
        );
        assertThat(
                msg.getFrom()[0].toString(),
                is("no-reply@bubl.guru")
        );
    }

    @Test
    public void has_correct_body() throws Exception {
        Message msg = new ForgotPasswordEmailImpl().send(
                user(),
                ""
        );
        assertTrue(
                msg.getContent().toString().contains(
                        "Follow this link to reset your password"
                )
        );
    }

    @Test
    public void if_user_preferred_locale_contains_french_it_translate_to_french() throws Exception {
        User user = user().setPreferredLocales(
                new JSONArray().put("fr").toString()
        );
        Message msg = new ForgotPasswordEmailImpl().send(
                user,
                ""
        );
        assertFalse(
                msg.getContent().toString().contains(
                        "Follow this link to reset your password:"
                )
        );
        assertTrue(
                msg.getContent().toString().contains(
                        "Suivez ce lien pour mettre à jour votre mot de passe"
                )
        );
    }

    @Test
    public void reset_url_is_in_email()throws Exception{
        Message msg = new ForgotPasswordEmailImpl().send(
                user(),
                "http://domain-url/reset/user-name/token"
        );
        assertTrue(
                msg.getContent().toString().contains(
                        "http://domain-url/reset/user-name/token"
                )
        );
    }

    private User user(){
        return User.withEmailAndUsername(
                "test@example.org",
                "test_username"
        );
    }
}
