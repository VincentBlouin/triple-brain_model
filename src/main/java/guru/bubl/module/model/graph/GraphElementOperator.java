/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.graph;

import guru.bubl.module.model.graph.identification.Identification;
import guru.bubl.module.model.graph.identification.IdentificationPojo;

import java.net.URI;
import java.util.Map;

public interface GraphElementOperator extends GraphElement, FriendlyResourceOperator {
    void remove();
    void removeIdentification(Identification type);
    Map<URI, IdentificationPojo> addType(Identification type);
    Map<URI, IdentificationPojo> addSameAs(Identification friendlyResource);
    Map<URI, IdentificationPojo> addGenericIdentification(Identification friendlyResource);
}
