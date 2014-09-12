/*
 * Copyright Vincent Blouin under the Mozilla Public License 1.1
 */

package org.triple_brain.module.model;

import java.util.Locale;

public class LocalizedString {

    private String string;
    private Locale locale;

    public LocalizedString(String string, Locale locale){
        this.string = string;
        this.locale = locale;
    }

    public String getString(){
        return string;
    }

    public Locale getLocale(){
        return locale;
    }
}
