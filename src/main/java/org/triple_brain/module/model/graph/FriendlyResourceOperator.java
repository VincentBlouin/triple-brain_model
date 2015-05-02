/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package org.triple_brain.module.model.graph;

import org.triple_brain.module.model.FriendlyResource;
import org.triple_brain.module.model.Image;

import java.util.Map;
import java.util.Set;

public interface FriendlyResourceOperator extends FriendlyResource {
    void comment(String comment);
    void label(String label);
    void addImages(Set<Image> images);
    void create();
    void createUsingInitialValues(Map<String, Object> values);
    void remove();
}
