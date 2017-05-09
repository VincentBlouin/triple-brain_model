/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.meta;

import guru.bubl.module.model.graph.identification.IdentifierPojo;

import java.util.Set;

public interface UserMetasOperator {
    Set<IdentifierPojo> get();
}
