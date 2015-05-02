/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package org.triple_brain.module.model.graph;

import org.triple_brain.module.model.FriendlyResource;

import java.net.URI;

public interface Identification extends FriendlyResource {
    URI getExternalResourceUri();
}
