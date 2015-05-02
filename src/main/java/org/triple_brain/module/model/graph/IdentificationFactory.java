/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package org.triple_brain.module.model.graph;

import java.net.URI;

public interface IdentificationFactory {
    IdentificationOperator withUri(URI uri);
}
