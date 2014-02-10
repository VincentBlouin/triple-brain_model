package org.triple_brain.module.model.suggestion;

import org.triple_brain.module.model.FriendlyResource;

import java.util.Set;

/*
* Copyright Mozilla Public License 1.1
*/
public interface Suggestion extends FriendlyResource{
    FriendlyResource sameAs();
    FriendlyResource domain();
    Set<SuggestionOrigin> origins();
}
