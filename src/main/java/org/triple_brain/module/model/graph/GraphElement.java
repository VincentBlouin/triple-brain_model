package org.triple_brain.module.model.graph;

import org.joda.time.DateTime;
import org.triple_brain.module.model.FriendlyResource;
import org.triple_brain.module.model.User;

import java.net.URI;
import java.util.Set;

/**
 * Copyright Mozilla Public License 1.1
 */
public interface GraphElement {
    public DateTime creationDate();
    public DateTime lastModificationDate();
    public URI uri();
    public String label();
    public void label(String label);
    public boolean hasLabel();
    public User owner();
    public void addSameAs(FriendlyResource friendlyResource);
    public Set<FriendlyResource> getSameAs();
    public void addType(FriendlyResource type);
    public void removeFriendlyResource(FriendlyResource type);
    public Set<FriendlyResource> getAdditionalTypes();
    public void remove();
}
