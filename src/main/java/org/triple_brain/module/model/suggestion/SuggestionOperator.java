/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package org.triple_brain.module.model.suggestion;

import org.triple_brain.module.model.FriendlyResource;
import org.triple_brain.module.model.graph.FriendlyResourceOperator;

public interface SuggestionOperator extends Suggestion, FriendlyResourceOperator{
    FriendlyResourceOperator sameAs();
    FriendlyResourceOperator domain();
    void remove();
    void removeOriginsThatDependOnResource(FriendlyResource resource);
}
