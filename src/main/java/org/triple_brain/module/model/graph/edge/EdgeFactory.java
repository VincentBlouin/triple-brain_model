/*
 * Copyright Vincent Blouin under the Mozilla Public License 1.1
 */

package org.triple_brain.module.model.graph.edge;

import java.net.URI;

public interface EdgeFactory {
    EdgeOperator createOrLoadUsingUri(URI uri);
}
