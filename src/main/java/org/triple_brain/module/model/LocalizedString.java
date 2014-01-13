package org.triple_brain.module.model;

import java.util.Locale;

/*
* Copyright Mozilla Public License 1.1
*/
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
