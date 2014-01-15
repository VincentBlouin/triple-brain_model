package org.triple_brain.module.model.suggestion;

import org.triple_brain.module.model.FriendlyResource;

/*
* Copyright Mozilla Public License 1.1
*/
public interface SuggestionOrigin extends FriendlyResource {
    public Boolean isRelatedToFriendlyResource(
            FriendlyResource friendlyResource
    );
}
