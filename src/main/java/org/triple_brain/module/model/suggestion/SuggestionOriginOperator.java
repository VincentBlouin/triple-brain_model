package org.triple_brain.module.model.suggestion;

import org.triple_brain.module.model.graph.FriendlyResourceOperator;

/*
* Copyright Mozilla Public License 1.1
*/
public interface SuggestionOriginOperator extends SuggestionOrigin, FriendlyResourceOperator{
    public void remove();
}
