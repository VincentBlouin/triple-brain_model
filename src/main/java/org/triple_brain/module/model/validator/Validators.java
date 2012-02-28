package org.triple_brain.module.model.validator;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static org.apache.commons.lang.StringUtils.isBlank;
import static org.triple_brain.module.model.json.UserJSONFields.*;
/**
 * @author Vincent Blouin
 */
public class Validators {

    public static final String INVALID_EMAIL = "invalid_email";
    public static final String UN_REGISTERED_EMAIL = "un_registered_email";
    public static final String ALREADY_VALIDATED = "already_validated";
    public static final String MANDATORY_EMAIL = "mandatory_email";
    public static final String EMAIL_TOO_LONG = "email_too_long";
    public static final String ALREADY_REGISTERED_EMAIL = "already_registered_email";

    public static final String INVALID_PASSWORD = "invalid_password";
    public static final String PASSWORD_VERIFICATION_ERROR = "password_verification_error";
    public static final String PASSWORD_TOO_SHORT = "password_to_short";
    public static final String MANDATORY_PASSWORD = "mandatory_password";
    public static final String MANDATORY_NEW_PASSWORD = "mandatory_new_password";

    public static final String INVALID_STATE = "invalid_state";

    private static String ATOM = "[^\\x00-\\x1F^\\(^\\)^\\<^\\>^\\@^\\,^\\;^\\:^\\\\^\\\"^\\.^\\[^\\]^\\s]";
    private static String DOMAIN = "(" + ATOM + "+(\\." + ATOM + "+)*";
    private static String IP_DOMAIN = "\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\]";

    private static Pattern email_pattern = Pattern.compile("^" + ATOM + "+(\\." + ATOM + "+)*@" + DOMAIN + "|" + IP_DOMAIN + ")$", Pattern.CASE_INSENSITIVE);

    public static Map<String, String> validateEmail(String field, String email) {
        Map<String, String> errors = new LinkedHashMap<String, String>();

        if (isBlank(email)) {
            errors.put(field, MANDATORY_EMAIL);
            return errors;
        }

        if (!isEmailValid(email)) {
            errors.put(field, INVALID_EMAIL);
            return errors;
        }

        if (email.length() > 50) {
            errors.put(field, EMAIL_TOO_LONG);
            return errors;
        }
        return errors;
    }

    public static Map<String, String> validatePassword(String field, String password, String passwordVerification) {
        Map<String, String> errors = new LinkedHashMap<String, String>();
        if (isBlank(password)) {
            errors.put(field, MANDATORY_PASSWORD);
            return errors;
        }

        if (password.length() < 6) {
            errors.put(field, PASSWORD_TOO_SHORT);
            return errors;
        }

        if (!password.equals(passwordVerification)) {
            errors.put(PASSWORD, Validators.PASSWORD_VERIFICATION_ERROR);
        }

        return errors;
    }

    public static boolean isEmailValid(String email) {
        if (isBlank(email)) return false;
        Matcher m = email_pattern.matcher(email);
        return m.matches();
    }

}
