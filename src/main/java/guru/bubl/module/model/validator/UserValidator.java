/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.validator;

import guru.bubl.module.model.json.UserJson;
import org.codehaus.jettison.json.JSONObject;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.apache.commons.lang.StringUtils.isBlank;

public class UserValidator {

    private static final String
            ATOM = "[^\\x00-\\x1F^\\(^\\)^\\<^\\>^\\@^\\,^\\;^\\:^\\\\^\\\"^\\.^\\[^\\]^\\s]",
            DOMAIN = "(" + ATOM + "+(\\." + ATOM + "+)*",
            IP_DOMAIN = "\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\]";
    private static final Pattern email_pattern = Pattern.compile(
            "^" + ATOM + "+(\\." + ATOM + "+)*@" + DOMAIN + "|" + IP_DOMAIN + ")$",
            Pattern.CASE_INSENSITIVE
    );
    private static final int EMAIL_MAX_LENGTH = 255;
    public static final String
            INVALID_EMAIL = "invalid_email",
            MANDATORY_EMAIL = "mandatory_email",
            EMAIL_TOO_LONG = "email_too_long",
            ALREADY_REGISTERED_EMAIL = "already_registered_email";

    private static final int PASSWORD_MIN_LENGTH = 6;
    public static final String
            PASSWORD_TOO_SHORT = "password_too_short",
            MANDATORY_PASSWORD = "mandatory_password";

    private static final int USER_NAME_MAX_LENGTH = 30;
    private static final String USERNAME_PATTERN = "^[a-z0-9_-]{1,30}$";
    public static final String
            MANDATORY_USER_NAME = "mandatory_user_name",
            INVALID_USER_NAME = "invalid_user_name",
            USER_NAME_TOO_LONG = "user_name_too_long",
            USER_NAME_ALREADY_REGISTERED = "user_name_already_registered";

    public static Map<String, String> errorsForUserAsJson(JSONObject user) {
        Map<String, String> errors = new LinkedHashMap<>();

        errors.putAll(errorsForEmail(user.optString(UserJson.EMAIL)));
        errors.putAll(validateUserName(user.optString(UserJson.USER_NAME)));
        errors.putAll(errorsForPassword(user.optString(UserJson.PASSWORD)));
        return errors;
    }

    private static Map<String, String> validateUserName(String username) {
        Map<String, String> errors = new LinkedHashMap<>();
        if (isBlank(username)) {
            errors.put(UserJson.USER_NAME, MANDATORY_USER_NAME);
            return errors;
        }
        if(username.length() > USER_NAME_MAX_LENGTH){
            errors.put(UserJson.USER_NAME, USER_NAME_TOO_LONG);
            return errors;
        }
        if(!isUserNameValid(username)){
            errors.put(UserJson.USER_NAME, INVALID_USER_NAME);
        }
        return errors;
    }

    private static boolean isUserNameValid(String username){
        return Pattern.compile(USERNAME_PATTERN).matcher(username).matches();
    }

    private static Map<String, String> errorsForEmail(String email) {
        Map<String, String> errors = new LinkedHashMap<>();

        if (isBlank(email)) {
            errors.put(UserJson.EMAIL, MANDATORY_EMAIL);
            return errors;
        }

        if (!isEmailValid(email)) {
            errors.put(UserJson.EMAIL, INVALID_EMAIL);
            return errors;
        }

        if (email.length() > EMAIL_MAX_LENGTH) {
            errors.put(UserJson.EMAIL, EMAIL_TOO_LONG);
            return errors;
        }
        return errors;
    }

    public static Map<String, String> errorsForPassword(String password) {
        Map<String, String> errors = new LinkedHashMap<>();
        if (isBlank(password)) {
            errors.put(UserJson.PASSWORD, MANDATORY_PASSWORD);
            return errors;
        }

        if (password.length() < PASSWORD_MIN_LENGTH) {
            errors.put(UserJson.PASSWORD, PASSWORD_TOO_SHORT);
            return errors;
        }
        return errors;
    }

    private static boolean isEmailValid(String email) {
        if (isBlank(email)) return false;
        Matcher m = email_pattern.matcher(email);
        return m.matches();
    }

}
