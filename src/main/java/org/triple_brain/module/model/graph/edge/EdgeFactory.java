/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package org.triple_brain.module.model.graph.edge;

import java.net.URI;

public interface EdgeFactory {
    EdgeOperator createOrLoadUsingUri(URI uri);
}
