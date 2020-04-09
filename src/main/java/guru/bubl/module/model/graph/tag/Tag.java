/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.graph.tag;

import guru.bubl.module.model.graph.GraphElement;
import guru.bubl.module.model.graph.fork.Fork;

import java.net.URI;

public interface Tag extends GraphElement, Fork {
    URI DEFAULT_IDENTIFIER_RELATION_EXTERNAL_URI = URI.create("generic");
    URI getRelationExternalResourceUri();
    URI getExternalResourceUri();
}
