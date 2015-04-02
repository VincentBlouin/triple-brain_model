/*
 * Copyright Vincent Blouin under the Mozilla Public License 1.1
 */

package org.triple_brain.module.model.validator;

import org.codehaus.jettison.json.JSONObject;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.apache.commons.lang.StringUtils.isBlank;
import static org.triple_brain.module.model.json.UserJson.*;

public class UserValidator {

    private static String ATOM = "[^\\x00-\\x1F^\\(^\\)^\\<^\\>^\\@^\\,^\\;^\\:^\\\\^\\\"^\\.^\\[^\\]^\\s]";
    private static String DOMAIN = "(" + ATOM + "+(\\." + ATOM + "+)*";
    private static String IP_DOMAIN = "\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\]";
    private static Pattern email_pattern = Pattern.compile("^" + ATOM + "+(\\." + ATOM + "+)*@" + DOMAIN + "|" + IP_DOMAIN + ")$", Pattern.CASE_INSENSITIVE);
    private static final int EMAIL_MAX_LENGTH = 255;
    
    public static final String INVALID_EMAIL = "invalid_email";
    public static final String MANDATORY_EMAIL = "mandatory_email";
    public static final String EMAIL_TOO_LONG = "email_too_long";
    public static final String ALREADY_REGISTERED_EMAIL = "already_registered_email";

    private static final int PASSWORD_MIN_LENGTH = 6;
    
    public static final String PASSWORD_VERIFICATION_ERROR = "password_verification_error";
    public static final String PASSWORD_TOO_SHORT = "password_too_short";
    public static final String MANDATORY_PASSWORD = "mandatory_password";

    public static Map<String, String> validate(JSONObject user) {
        Map<String, String> errors = new LinkedHashMap<String, String>();

        errors.putAll(validateEmail(user.optString(EMAIL)));
        errors.putAll(validatePassword(user.optString(PASSWORD), user.optString(PASSWORD_VERIFICATION)));
        return errors;
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
