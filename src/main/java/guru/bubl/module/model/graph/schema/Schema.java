/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.graph.schema;

import guru.bubl.module.model.graph.GraphElement;

import java.net.URI;
import java.util.Map;

public interface Schema extends GraphElement {
    Map<URI, ?extends GraphElement> getProperties();
}
