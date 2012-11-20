package org.triple_brain.module.model;

import java.util.Set;

/*
* Copyright Mozilla Public License 1.1
*/
public interface ExternalFriendlyResourcePersistenceUtils {
    public void setDescription(ExternalFriendlyResource externalFriendlyResource, String description);
    public void addImages(ExternalFriendlyResource externalFriendlyResource, Set<Image> images);
    public ExternalFriendlyResource getUpdated(ExternalFriendlyResource externalFriendlyResource);
}
