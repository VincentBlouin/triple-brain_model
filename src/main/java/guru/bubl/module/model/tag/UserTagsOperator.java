/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.tag;

import guru.bubl.module.model.graph.tag.TagPojo;

import java.util.Set;

public interface UserTagsOperator {
    Set<TagPojo> get();
}
