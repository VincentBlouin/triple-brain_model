package org.triple_brain.module.model.graph;

import org.joda.time.DateTime;
import org.triple_brain.module.model.ExternalFriendlyResource;
import org.triple_brain.module.model.User;

import java.net.URI;
import java.util.Set;

/**
 * Copyright Mozilla Public License 1.1
 */
public interface GraphElement {
    public DateTime creationDate();
    public DateTime lastModificationDate();
    public String id();
    public String label();
    public void label(String label);
    public boolean hasLabel();
    public User owner();
    public void addSameAs(ExternalFriendlyResource friendlyResource);
    public Set<ExternalFriendlyResource> getSameAs();
    public ExternalFriendlyResource friendlyResourceWithUri(URI uri);
    public void addType(ExternalFriendlyResource type);
    public void removeFriendlyResource(ExternalFriendlyResource type);
    public Set<ExternalFriendlyResource> getAdditionalTypes();
}
