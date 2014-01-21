package org.triple_brain.module.model.graph;

import org.triple_brain.module.model.FriendlyResource;

import java.util.Set;

/**
 * Copyright Mozilla Public License 1.1
 */
public interface GraphElement extends FriendlyResource{
    public Set<FriendlyResource> getGenericIdentifications();
    public Set<FriendlyResource> getSameAs();
    public Set<FriendlyResource> getAdditionalTypes();
    public Set<FriendlyResource> getIdentifications();
    public String ownerUsername();
}
