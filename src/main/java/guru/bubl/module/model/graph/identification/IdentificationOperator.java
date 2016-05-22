/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.graph.identification;

import guru.bubl.module.model.graph.FriendlyResourceOperator;

public interface IdentificationOperator extends Identification, FriendlyResourceOperator {
    void setNbReferences(Integer nb);
}
