/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package org.triple_brain.module.model.suggestion;

import org.triple_brain.module.model.FriendlyResource;

public interface SuggestionOrigin extends FriendlyResource {
    public Boolean isRelatedToFriendlyResource(
            FriendlyResource friendlyResource
    );
}
