/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model;

import org.codehaus.jettison.json.JSONObject;
import org.junit.Test;

import java.util.Map;

import static junit.framework.Assert.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static guru.bubl.module.model.json.UserJson.*;
import static guru.bubl.module.model.validator.UserValidator.*;
import static org.junit.Assert.assertFalse;

public class UserValidatorTest {

    @Test
    public void email_is_mandatory() throws Exception {
        assertTrue(
                validationWithUserReturnsFieldWithMessage(
                        validUserButWithFieldValue(EMAIL, ""),
                        EMAIL,
                        MANDATORY_EMAIL)
        );
    }

    @Test
    public void email_has_to_be_valid() throws Exception {
        assertTrue(
                validationWithUserReturnsFieldWithMessage(
                        validUserButWithFieldValue(
                                EMAIL,
                                "roger.lamothe$example.org"
                        ),
                        EMAIL,
                        INVALID_EMAIL)
        );
    }

    @Test
    public void password_is_mandatory() throws Exception {
        assertTrue(
                validationWithUserReturnsFieldWithMessage(
                        validUserButWithFieldValue(
                                PASSWORD,
                                ""
                        ),
                        PASSWORD,
                        MANDATORY_PASSWORD)
        );
    }

    @Test
    public void password_cant_be_too_short() throws Exception {
        assertTrue(
                validationWithUserReturnsFieldWithMessage(
                        validUser()
                                .put(PASSWORD, "pass"),
                        PASSWORD,
                        PASSWORD_TOO_SHORT)
        );
    }

    @Test
    public void username_is_mandatory() throws Exception {
        assertTrue(
                validationWithUserReturnsFieldWithMessage(
                        validUserButWithFieldValue(USER_NAME, ""),
                        USER_NAME,
                        MANDATORY_USER_NAME)
        );
    }

    @Test
    public void username_has_to_be_valid() throws Exception {
        assertTrue(
                validationWithUserReturnsFieldWithMessage(
                        validUserButWithFieldValue(
                                USER_NAME,
                                "roger/lamothe"
                        ),
                        USER_NAME,
                        INVALID_USER_NAME)
        );
    }

    @Test
    public void username_cant_have_spaces() throws Exception {
        assertTrue(
                validationWithUserReturnsFieldWithMessage(
                        validUserButWithFieldValue(
                                USER_NAME,
                                "roger lamothe"
                        ),
                        USER_NAME,
                        INVALID_USER_NAME)
        );
    }

    @Test
    public void username_cant_have_dots() throws Exception {
        assertTrue(
                validationWithUserReturnsFieldWithMessage(
                        validUserButWithFieldValue(
                                USER_NAME,
                                "roger.lamtothe"
                        ),
                        USER_NAME,
                        INVALID_USER_NAME)
        );
    }

    @Test
    public void username_cant_have_backslash() throws Exception {
        assertTrue(
                validationWithUserReturnsFieldWithMessage(
                        validUserButWithFieldValue(
                                USER_NAME,
                                "roger\\lamtothe"
                        ),
                        USER_NAME,
                        INVALID_USER_NAME)
        );
    }

    @Test
    public void username_cant_be_too_long() throws Exception {
        assertTrue(
                validationWithUserReturnsFieldWithMessage(
                        validUserButWithFieldValue(
                                USER_NAME,
                                "roger_lamotheeeeeeeeeeeeeeeeeee"
                        ),
                        USER_NAME,
                        USER_NAME_TOO_LONG)
        );
    }

    @Test
    public void username_can_have_capital_letters() throws Exception {
        assertTrue(
                errorsForUserAsJson(validUserButWithFieldValue(
                        USER_NAME,
                        "RogerLamothe"
                )).isEmpty()
        );
    }

    @Test
    public void username_can_have_accents() throws Exception {
        assertTrue(
                errorsForUserAsJson(validUserButWithFieldValue(
                        USER_NAME,
                        "RogéLamothe"
                )).isEmpty()
        );
    }

    @Test
    public void username_can_have_numbers() throws Exception {
        assertTrue(
                errorsForUserAsJson(
                        validUserButWithFieldValue(
                                USER_NAME,
                                "r0g3rl4mt0th3"
                        )
                ).isEmpty()
        );
    }

    private boolean validationWithUserReturnsFieldWithMessage(JSONObject user, String field, String message) {
        Map<String, String> errors;
        errors = errorsForUserAsJson(user);
        assertThat(errors.get(field), is(notNullValue()));
        assertThat(errors.get(field), is(message));
        return true;
    }

    private JSONObject validUserButWithFieldValue(String fieldName, String value) throws Exception {
        return validUser().put(fieldName, value);
    }

    private JSONObject validUser() throws Exception {
        JSONObject user = new JSONObject();
        user.put(EMAIL, "generated_email@example.org");
        user.put(PASSWORD, "generated password");
        return user;
    }
}
