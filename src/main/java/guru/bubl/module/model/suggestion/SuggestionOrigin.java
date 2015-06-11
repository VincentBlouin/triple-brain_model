/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.suggestion;

import guru.bubl.module.model.FriendlyResource;

public interface SuggestionOrigin extends FriendlyResource {
    public Boolean isRelatedToFriendlyResource(
            FriendlyResource friendlyResource
    );
}
