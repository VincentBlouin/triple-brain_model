package org.triple_brain.module.model.suggestion;

import org.triple_brain.module.model.FriendlyResource;

import java.net.URI;
import java.util.Set;

/*
* Copyright Mozilla Public License 1.1
*/
public interface Suggestion extends FriendlyResource{
    URI getSameAsUri();
    URI getDomainUri();
    Set<?extends SuggestionOrigin> origins();
}
