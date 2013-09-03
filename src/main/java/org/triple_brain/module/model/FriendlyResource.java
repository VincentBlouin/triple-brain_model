package org.triple_brain.module.model;

import org.joda.time.DateTime;

import java.net.URI;
import java.util.Set;

/*
* Copyright Mozilla Public License 1.1
*/
public interface FriendlyResource {
    public URI uri();
    public String label();
    public void label(String label);
    public Set<Image> images();
    public Boolean gotTheImages();
    public String comment();
    public void comment(String comment);
    public Boolean gotComments();
    public void addImages(Set<Image> images);
    public DateTime creationDate();
    public DateTime lastModificationDate();
}
