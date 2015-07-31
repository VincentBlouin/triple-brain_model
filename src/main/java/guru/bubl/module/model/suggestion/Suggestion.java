/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.suggestion;

import guru.bubl.module.model.FriendlyResource;
import guru.bubl.module.model.graph.FriendlyResourcePojo;

import java.util.Set;

public interface Suggestion extends FriendlyResource {
    String SUGGESTION_IDENTIFICATION_PREFIX = "identification_";
    FriendlyResourcePojo getSameAs();
    FriendlyResourcePojo getType();
    Set<?extends SuggestionOrigin> origins();
}
