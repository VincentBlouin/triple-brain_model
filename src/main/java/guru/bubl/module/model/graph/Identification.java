/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.graph;

import guru.bubl.module.model.FriendlyResource;

import java.net.URI;

public interface Identification extends FriendlyResource {
    URI getExternalResourceUri();
    Integer getNbReferences();
}
