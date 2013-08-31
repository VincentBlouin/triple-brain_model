package org.triple_brain.module.model;

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
    public String description();
    public void description(String description);
    public Boolean gotADescription();
    public void addImages(Set<Image> images);
}
