/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.graph;

import guru.bubl.module.model.graph.tag.Tag;
import guru.bubl.module.model.graph.tag.TagPojo;

import java.net.URI;
import java.util.Map;

public interface GraphElementOperator extends GraphElement, FriendlyResourceOperator {
    enum colorProps{
      background
    };
    void remove();
    void removeIdentification(Tag type);
    Map<URI, TagPojo> addMeta(Tag friendlyResource);
    void setFont(String font);
    void setChildrenIndex(String childrenIndex);
}
