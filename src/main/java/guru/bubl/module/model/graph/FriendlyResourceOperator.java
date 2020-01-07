/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.graph;

import guru.bubl.module.model.FriendlyResource;
import guru.bubl.module.model.Image;

import java.net.URI;
import java.util.Map;
import java.util.Set;

public interface FriendlyResourceOperator extends FriendlyResource {
    void comment(String comment);
    void label(String label);
    void addImages(Set<Image> images);
    void create();
    void createUsingInitialValues(Map<String, Object> values);
    void remove();
    void setColors(String colors);
}
