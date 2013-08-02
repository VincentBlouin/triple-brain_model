package org.triple_brain.module.model.validator;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.apache.commons.lang.StringUtils.isBlank;
import static org.triple_brain.module.model.json.UserJsonFields.*;

/**
 * Copyright Mozilla Public License 1.1
 */

public class UserValidator {

    private static String ATOM = "[^\\x00-\\x1F^\\(^\\)^\\<^\\>^\\@^\\,^\\;^\\:^\\\\^\\\"^\\.^\\[^\\]^\\s]";
    private static String DOMAIN = "(" + ATOM + "+(\\." + ATOM + "+)*";
    private static String IP_DOMAIN = "\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\]";
    private static Pattern email_pattern = Pattern.compile("^" + ATOM + "+(\\." + ATOM + "+)*@" + DOMAIN + "|" + IP_DOMAIN + ")$", Pattern.CASE_INSENSITIVE);
    private static int EMAIL_MAX_LENGTH = 255;
    
    public static final String INVALID_EMAIL = "invalid_email";
    public static final String MANDATORY_EMAIL = "mandatory_email";
    public static final String EMAIL_TOO_LONG = "email_too_long";
    public static final String ALREADY_REGISTERED_EMAIL = "already_registered_email";

    private static final int PASSWORD_MIN_LENGTH = 6;
    
    public static final String PASSWORD_VERIFICATION_ERROR = "password_verification_error";
    public static final String PASSWORD_TOO_SHORT = "password_too_short";
    public static final String MANDATORY_PASSWORD = "mandatory_password";

    public static final String LOCALES_MANDATORY = "locales_mandatory";

    private static final int USER_NAME_MAX_LENGTH = 50;
    private static final String USERNAME_PATTERN = "^[a-z0-9_-]{1,50}$";

    public static final String MANDATORY_USER_NAME = "mandatory_user_name";
    public static final String INVALID_USER_NAME = "invalid_user_name";
    public static final String USER_NAME_TOO_LONG = "user_name_too_long";
    public static final String USER_NAME_ALREADY_REGISTERED = "user_name_already_registered";


    public static Map<String, String> validate(JSONObject user) {
        Map<String, String> errors = new LinkedHashMap<String, String>();

        errors.putAll(validateEmail(user.optString(EMAIL)));
        errors.putAll(validateUserName(user.optString(USER_NAME)));
        errors.putAll(validatePassword(user.optString(PASSWORD), user.optString(PASSWORD_VERIFICATION)));
        errors.putAll(validateLocales(user.optJSONArray(PREFERRED_LOCALES)));
        return errors;
    }

    private static Map<String, String> validateUserName(String username) {
        Map<String, String> errors = new LinkedHashMap<String, String>();
        if (isBlank(username)) {
            errors.put(USER_NAME, MANDATORY_USER_NAME);
            return errors;
        }
        if(username.length() > USER_NAME_MAX_LENGTH){
            errors.put(USER_NAME, USER_NAME_TOO_LONG);
            return errors;
        }
        if(!isUserNameValid(username)){
            errors.put(USER_NAME, INVALID_USER_NAME);
        }
        return errors;
    }

    private static boolean isUserNameValid(String username){
        return Pattern.compile(USERNAME_PATTERN).matcher(username).matches();
    }



    private static Map<String, String> validateEmail(String email) {
        Map<String, String> errors = new LinkedHashMap<String, String>();

        if (isBlank(email)) {
            errors.put(EMAIL, MANDATORY_EMAIL);
            return errors;
        }

        if (!isEmailValid(email)) {
            errors.put(EMAIL, INVALID_EMAIL);
            return errors;
        }

        if (email.length() > EMAIL_MAX_LENGTH) {
            errors.put(EMAIL, EMAIL_TOO_LONG);
            return errors;
        }
        return errors;
    }

    private static Map<String, String> validateLocales(JSONArray locales){
        Map<String, String> errors = new LinkedHashMap<String, String>();
        if(locales.length() == 0){
            errors.put(
                    PREFERRED_LOCALES,
                    LOCALES_MANDATORY
            );
        }
        return errors;
    }

    private static Map<String, String> validatePassword(String password, String passwordVerification) {
        Map<String, String> errors = new LinkedHashMap<String, String>();
        if (isBlank(password)) {
            errors.put(PASSWORD, MANDATORY_PASSWORD);
            return errors;
        }

        if (password.length() < PASSWORD_MIN_LENGTH) {
            errors.put(PASSWORD, PASSWORD_TOO_SHORT);
            return errors;
        }

        if (!password.equals(passwordVerification)) {
            errors.put(PASSWORD, PASSWORD_VERIFICATION_ERROR);
        }

        return errors;
    }

    private static boolean isEmailValid(String email) {
        if (isBlank(email)) return false;
        Matcher m = email_pattern.matcher(email);
        return m.matches();
    }

}
