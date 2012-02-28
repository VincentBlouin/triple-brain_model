package org.triple_brain.module.model.validator;

import org.triple_brain.module.model.User;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.apache.commons.lang.StringUtils.isBlank;
import static org.triple_brain.module.model.json.UserJSONFields.*;

/**
 * @author Vincent Blouin
 */

public class UserValidator {

    public static final String MANDATORY_FIRST_NAME = "mandatory_first_name";
    public static final String FIRST_NAME_TOO_LONG = "first_name_too_long";

    public static final String MANDATORY_LAST_NAME = "mandatory_last_name";
    public static final String LAST_NAME_TOO_LONG = "last_name_too_long";

    public static Map<String, String> validate(User user) {
        Map<String, String> errors = new LinkedHashMap<String, String>();
        if (isBlank(user.firstName())) {
            errors.put(FIRST_NAME, MANDATORY_FIRST_NAME);
        }
        if (isBlank(user.lastName())) {
            errors.put(LAST_NAME, MANDATORY_LAST_NAME);
        }

        if (user.firstName().length() > 50) {
            errors.put(FIRST_NAME, FIRST_NAME_TOO_LONG);
        }

        if (user.lastName().length() > 50) {
            errors.put(LAST_NAME, LAST_NAME_TOO_LONG);
        }
        return errors;
    }
}
