/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model;

import guru.bubl.module.model.graph.identification.Identifier;
import guru.bubl.module.model.search.GraphElementSearchResult;

import java.util.Set;

public interface IdentifiedTo {
    Set<GraphElementSearchResult> getForIdentificationAndUser(
            Identifier identification,
            User user
    );
}
