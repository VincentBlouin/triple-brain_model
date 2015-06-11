/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.suggestion;

import guru.bubl.module.model.graph.FriendlyResourceOperator;

public interface SuggestionOriginOperator extends SuggestionOrigin, FriendlyResourceOperator{
    public void remove();
}
