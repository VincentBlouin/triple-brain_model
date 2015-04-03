/*
 * Copyright Vincent Blouin under the Mozilla Public License 1.1
 */

package org.triple_brain.module.model;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.triple_brain.module.model.json.UserJson;

import java.util.Locale;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.triple_brain.module.model.json.UserJson.*;

public class UserTest {

    @Test
    public void can_create_user() {
        User user = User.withEmail(
                "roger.lamothe@example.org"
        );
        assertNotNull(
                user.id()
        );
        assertThat(
                user.email(),
                is("roger.lamothe@example.org")
        );
    }

    @Test
    public void can_modify_user() {
        User user = User.withEmail(
                "email@mail.org"
        );
        user.password("secret");
        user.setPreferredLocales("[fr]");
        user.setUsername("some-username");
        assertTrue(
                user.hasPassword("secret")
        );
        assertThat(
                user.getPreferredLocalesAsString(),
                is("[fr]")
        );
        assertThat(
                user.username(),
                is("some-username")
        );
    }

    @Test
    public void equality_is_based_on_email() {
        User user_1 = User.withEmail(
                "email_1@mail.org"
        );
        User user_2 = User.withEmail(
                "email_2@mail.org"
        );
        User user_3 = User.withEmail(
                "email_1@mail.org"
        );
        assertThat(
                user_1,
                is(not(equalTo(user_2)))
        );
        assertThat(
                user_1,
                is(equalTo(user_3))
        );
    }

    @Test
    public void email_is_always_saved_in_lower_case_and_trimed() {
        User user = User.withEmail(
                "  Email@mail.org  "
        );
        assertThat(
                user.email(),
                Matchers.is("email@mail.org")
        );
    }

    @Test
    public void password_is_encoded_with_salt() {
        String password = "Potatoe";
        User user = User.withEmail(
                "roger@lamothe.org"
        ).password(password);
        String expectedPasswordHash = Base64.encodeBase64URLSafeString(
                DigestUtils.sha512(
                        password + user.salt()
                )
        );
        assertThat(
                user.passwordHash(),
                is(
                        expectedPasswordHash
                )
        );
    }

    @Test
    public void can_clean_password() {
        User user = User.withEmail(
                "roger@lamothe.org"
        ).password("potatoe");
        assertTrue(
                user.hasPassword("potatoe")
        );

        user.resetPassword();
        assertFalse(
                user.hasPassword("potatoe")
        );
        assertNull(
                user.passwordHash()
        );
    }

    @Test
    public void hashCode_is_based_on_email() {
        User member = User.withEmail(
                "roger.lamothe@example.org"
        );
        assertThat(
                member.hashCode(),
                is("roger.lamothe@example.org".hashCode()
                )
        );
    }

    @Test
    public void toString_gives_user_email() {
        User user = User.withEmail(
                "roger.lamothe@example.org"
        );
        assertThat(
                user.toString(),
                is("roger.lamothe@example.org")
        );
    }

    @Test
    public void can_get_json_representation_of_user() throws Exception {
        User user = User.withEmail(
                "roger.lamothe@example.org"
        );
        JSONObject jsonUser = UserJson.toJson(user);
        assertThat(
                jsonUser.getString(EMAIL),
                is("roger.lamothe@example.org")
        );
    }

    @Test
    public void can_get_preferred_locales_of_user()throws Exception{
        User user = User.withEmail(
                "some_email@example.org"
        ).setPreferredLocales(new JSONArray().put("fr").toString());
        assertTrue(
                user.getPreferredLocales().contains(
                        Locale.FRENCH
                )
        );
    }

    @Test
    public void can_get_preferred_locales_as_json_array_even_if_locale_string_is_empty()throws Exception{
        User user = User.withEmail(
                "some_email@example.org"
        ).setPreferredLocales(
                ""
        );
        try{
            user.getPreferredLocalesAsJsonArray();
        }catch(Exception e){
            fail();
        }
    }

}
