/*
 * Copyright Vincent Blouin under the Mozilla Public License 1.1
 */

package org.triple_brain.module.model.suggestion;

import org.triple_brain.module.model.FriendlyResource;
import org.triple_brain.module.model.graph.FriendlyResourcePojo;

import java.util.Set;

public interface Suggestion extends FriendlyResource{
    public static final String SUGGESTION_IDENTIFICATION_PREFIX = "identification_";
    FriendlyResourcePojo getSameAs();
    FriendlyResourcePojo getType();
    Set<?extends SuggestionOrigin> origins();
}
