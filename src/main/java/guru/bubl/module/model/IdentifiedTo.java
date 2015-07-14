/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model;

import guru.bubl.module.model.graph.FriendlyResourcePojo;
import guru.bubl.module.model.graph.Identification;

import java.util.Set;

public interface IdentifiedTo {
    Set<FriendlyResourcePojo> getForIdentificationAndUser(
            Identification identification,
            User user
    );
}
