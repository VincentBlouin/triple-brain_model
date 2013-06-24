package org.triple_brain.module.model.graph;

import org.joda.time.DateTime;
import org.triple_brain.module.model.User;

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
}
