package org.triple_brain.module.model.graph;

import org.triple_brain.module.model.FriendlyResource;

import java.util.Map;

/*
* Copyright Mozilla Public License 1.1
*/
public interface GraphElementOperator extends FriendlyResourceOperator, GraphElement {
    void remove();
    void removeIdentification(FriendlyResource type);
    FriendlyResourcePojo addType(FriendlyResource type);
    FriendlyResourcePojo addSameAs(FriendlyResource friendlyResource);
    FriendlyResourcePojo addGenericIdentification(FriendlyResource friendlyResource);
}
