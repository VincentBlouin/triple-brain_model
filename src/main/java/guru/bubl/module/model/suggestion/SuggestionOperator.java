/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.suggestion;

import guru.bubl.module.model.FriendlyResource;
import guru.bubl.module.model.graph.FriendlyResourceOperator;

public interface SuggestionOperator extends Suggestion, FriendlyResourceOperator{
    FriendlyResourceOperator sameAs();
    FriendlyResourceOperator domain();
    void remove();
    void removeOriginsThatDependOnResource(FriendlyResource resource);
}
