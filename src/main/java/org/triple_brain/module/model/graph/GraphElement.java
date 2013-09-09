package org.triple_brain.module.model.graph;

import org.triple_brain.module.model.FriendlyResource;

import java.util.Set;

/**
 * Copyright Mozilla Public License 1.1
 */
public interface GraphElement extends FriendlyResource{
    public boolean hasLabel();
    public void addGenericIdentification(FriendlyResource friendlyResource);
    public Set<FriendlyResource> getGenericIdentifications();
    public void addSameAs(FriendlyResource friendlyResource);
    public Set<FriendlyResource> getSameAs();
    public void addType(FriendlyResource type);
    public void removeIdentification(FriendlyResource type);
    public Set<FriendlyResource> getAdditionalTypes();
    public Set<FriendlyResource> getIdentifications();
    public void remove();
    public String ownerUsername();
}
