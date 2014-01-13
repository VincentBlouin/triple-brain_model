package org.triple_brain.module.model;

import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/*
* Copyright Mozilla Public License 1.1
*/
public class InternationalString {
    //use hashmap?
    Map<Locale, String>asdf;
    Set<LocalizedString> localizedStrings = new HashSet<>();
    public void add(LocalizedString localizedString){
        localizedStrings.add(localizedString);
    }
    public Set<LocalizedString> getLocalizedStrings(){
        return localizedStrings;
    }
}
