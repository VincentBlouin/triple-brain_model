/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package org.triple_brain.module.model.graph.schema;

import org.triple_brain.module.model.FriendlyResource;
import org.triple_brain.module.model.graph.GraphElement;

import java.net.URI;
import java.util.Map;

public interface Schema extends FriendlyResource {
    Map<URI, ?extends GraphElement> getProperties();
}
