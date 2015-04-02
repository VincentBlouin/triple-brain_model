/*
 * Copyright Vincent Blouin under the Mozilla Public License 1.1
 */

package org.triple_brain.module.model.json;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.triple_brain.module.model.User;

public class UserJson {
    public static String ID = "uri";
    public static String USER_NAME = "user_name";
    public static String EMAIL = "email";
    public static String PASSWORD = "password";
    public static final String PREFERRED_LOCALES = "preferred_locales";

    public static JSONObject toJson(User user){
        try{
            return new JSONObject()
                    .put(
                            ID, user.id()
                    )
                    .put(
                            USER_NAME, user.username()
                    ).put(
                            EMAIL, user.email()
                    )
                    .put(
                            PREFERRED_LOCALES, user.preferredLocales()
                    );
        }catch(JSONException e){
            throw new RuntimeException(e);
        }

    }
}
