/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.graph.identification;

import guru.bubl.module.model.graph.FriendlyResourceOperator;
import guru.bubl.module.model.graph.GraphElementOperator;

import java.net.URI;

public interface IdentificationOperator extends Identifier, GraphElementOperator {
    void setNbReferences(Integer nb);
    void setExternalResourceUri(URI uri);
    IdentifierPojo buildPojo();
    void mergeTo(Identifier identifier);
}
