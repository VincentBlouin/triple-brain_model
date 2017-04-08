/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.graph.identification;

import guru.bubl.module.model.FriendlyResource;

import java.net.URI;

public interface Identification extends FriendlyResource {
    URI DEFAULT_IDENTIFIER_RELATION_EXTERNAL_URI = URI.create("generic");
    URI getRelationExternalResourceUri();
    URI getExternalResourceUri();
    Integer getNbReferences();
}
