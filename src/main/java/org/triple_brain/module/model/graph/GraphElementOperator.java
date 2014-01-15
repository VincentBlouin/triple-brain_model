package org.triple_brain.module.model.graph;

import org.triple_brain.module.model.FriendlyResource;

/*
* Copyright Mozilla Public License 1.1
*/
public interface GraphElementOperator extends FriendlyResourceOperator, GraphElement {
    public void remove();
    public void removeIdentification(FriendlyResource type);
    public void addType(FriendlyResource type);
    public void addSameAs(FriendlyResource friendlyResource);
    public void addGenericIdentification(FriendlyResource friendlyResource);
}
