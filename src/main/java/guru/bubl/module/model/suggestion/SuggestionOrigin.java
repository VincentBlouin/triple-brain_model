/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.suggestion;

import guru.bubl.module.model.FriendlyResource;

public interface SuggestionOrigin extends FriendlyResource {
    Boolean isRelatedToFriendlyResource(
            FriendlyResource friendlyResource
    );

    default String getType() {
        return this.toString().substring(
                0,
                this.toString().indexOf("_")
        );
    }
}
