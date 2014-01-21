package org.triple_brain.module.model;

import org.joda.time.DateTime;

import java.net.URI;
import java.util.Set;

/*
* Copyright Mozilla Public License 1.1
*/
public interface FriendlyResource {
    public URI uri();
    public boolean hasLabel();
    public String label();
    public Set<Image> images();
    public Boolean gotImages();
    public String comment();
    public Boolean gotComments();
    public DateTime creationDate();
    public DateTime lastModificationDate();
}
