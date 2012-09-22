package org.triple_brain.module.model.json;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.triple_brain.module.model.User;

/**
 * Copyright Mozilla Public License 1.1
 */
public class UserJSONFields {
    public static String ID = "id";
    public static String USER_NAME = "user_name";
    public static String EMAIL = "email";
    public static String PASSWORD = "password";
    public static final String PASSWORD_VERIFICATION = "password_verification";

    public static JSONObject toJSON(User user) throws JSONException {
        return new JSONObject()
                .put(
                        ID, user.id()
                )
                .put(
                        USER_NAME, user.username()
                ).put(
                        EMAIL, user.email()
                );
    }
}
