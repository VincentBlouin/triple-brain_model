/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.LocaleUtils;
import org.apache.commons.lang.StringUtils;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;

import java.util.*;

public class User {

    private String username,
            email,
            passwordHash,
            salt,
            preferredLocales = new JSONArray().toString();

    private Date consultNotificationDate;

    public static User withEmailAndUsername(String email, String username) {
        return new User(
                email,
                username
        );
    }

    public static User withEmail(String email) {
        return new User(email, null);
    }

    public static User withUsername(String username) {
        return new User("", username);
    }

    private User(String email, String username) {
        this.username = username;
        this.email = email.toLowerCase().trim();
    }

    public String passwordHash() {
        return passwordHash;
    }

    public boolean hasPassword(String password) {
        return passwordHash != null && encode(password).equals(passwordHash);
    }

    public User password(String password) {
        if (password != null) {
            salt = UUID.randomUUID().toString();
            passwordHash = encode(password);
        }
        return this;
    }

    public void resetPassword() {
        passwordHash = null;
    }

    private String encode(String password) {
        if (password == null)
            throw new IllegalArgumentException("Missing password");

        // the salt is composed of the email and salt. This way, two member objects with
        // the same email and same password can have two different hash
        return Base64.encodeBase64URLSafeString(DigestUtils.sha512(password + salt));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return email.equals(user.email);
    }

    @Override
    public int hashCode() {
        return email.hashCode();
    }

    @Override
    public String toString() {
        return email;
    }

    public String salt() {
        return salt;
    }

    public String username() {
        return username;
    }

    public String email() {
        return email;
    }

    public String getPreferredLocalesAsString() {
        return preferredLocales;
    }

    public List<Locale> getPreferredLocales() {
        List<Locale> locales = new ArrayList<>();
        JSONArray localesJsonArray = getPreferredLocalesAsJsonArray();
        for (int i = 0; i < localesJsonArray.length(); i++) {
            try {
                locales.add(
                        LocaleUtils.toLocale(
                                localesJsonArray.getString(i)
                        )
                );
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
        return locales;
    }

    public Locale getLocaleForBundle() {
        return getPreferredLocales().toString().toLowerCase().contains(
                Locale.FRENCH.toString().toLowerCase()
        ) ? Locale.FRENCH : Locale.ENGLISH;
    }

    public JSONArray getPreferredLocalesAsJsonArray() {
        try {
            return StringUtils.isEmpty(
                    getPreferredLocalesAsString()
            ) ? new JSONArray() :
                    new JSONArray(getPreferredLocalesAsString());
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public String id() {
        return new UserUris(this).baseUri().toString();
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public User setPreferredLocales(String preferredLocales) {
        this.preferredLocales = preferredLocales;
        return this;
    }

    public User setPreferredLocales(List<Locale> preferredLocales) {
        this.preferredLocales = preferredLocales.toString();
        return this;
    }

    public Date getConsultNotificationDate() {
        return consultNotificationDate;
    }

    public void setConsultNotificationDate(Date consultNotificationDate) {
        this.consultNotificationDate = consultNotificationDate;
    }
}
