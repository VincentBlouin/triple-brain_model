package org.triple_brain.module.model.graph;

import org.triple_brain.module.model.FriendlyResource;
import org.triple_brain.module.model.User;

import java.util.Set;

/**
 * Copyright Mozilla Public License 1.1
 */
public interface GraphElement extends FriendlyResource{
    public boolean hasLabel();
    public User owner();
    public void addSameAs(FriendlyResource friendlyResource);
    public Set<FriendlyResource> getSameAs();
    public void addType(FriendlyResource type);
    public void removeIdentification(FriendlyResource type);
    public Set<FriendlyResource> getAdditionalTypes();
    public void remove();
}
