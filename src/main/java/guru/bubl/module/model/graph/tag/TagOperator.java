/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.graph.tag;

import guru.bubl.module.model.graph.GraphElementOperator;

import java.net.URI;

public interface TagOperator extends Tag, GraphElementOperator {
    void setNbReferences(Integer nb);
    void setExternalResourceUri(URI uri);
    TagPojo buildPojo();
    void mergeTo(Tag tag);
}
