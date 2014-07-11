package org.triple_brain.module.model.graph;

import org.triple_brain.module.model.FriendlyResource;

import java.util.Map;

/*
* Copyright Mozilla Public License 1.1
*/
public interface GraphElementOperator extends GraphElement, IdentificationOperator {
    void remove();
    void removeIdentification(Identification type);
    IdentificationPojo addType(Identification type);
    IdentificationPojo addSameAs(Identification friendlyResource);
    IdentificationPojo addGenericIdentification(Identification friendlyResource);
}
