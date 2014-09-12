/*
 * Copyright Vincent Blouin under the Mozilla Public License 1.1
 */

package org.triple_brain.module.model.suggestion;

import org.triple_brain.module.model.graph.FriendlyResourceOperator;

public interface SuggestionOriginOperator extends SuggestionOrigin, FriendlyResourceOperator{
    public void remove();
}
