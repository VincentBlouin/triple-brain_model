/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.graph;

import guru.bubl.module.model.graph.identification.Identifier;
import guru.bubl.module.model.graph.identification.IdentifierPojo;

import java.net.URI;
import java.util.Date;
import java.util.Map;

public interface GraphElementOperator extends GraphElement, FriendlyResourceOperator {
    enum colorProps{
      background
    };
    void remove();
    void removeIdentification(Identifier type);
    Map<URI, IdentifierPojo> addMeta(Identifier friendlyResource);
    void setFont(String font);
    void setChildrenIndex(String childrenIndex);
}
