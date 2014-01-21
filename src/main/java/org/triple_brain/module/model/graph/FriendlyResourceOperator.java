package org.triple_brain.module.model.graph;

import org.triple_brain.module.model.FriendlyResource;
import org.triple_brain.module.model.Image;

import java.util.Set;

/*
* Copyright Mozilla Public License 1.1
*/
public interface FriendlyResourceOperator extends FriendlyResource {
    public void comment(String comment);
    public void label(String label);
    public void addImages(Set<Image> images);
}
