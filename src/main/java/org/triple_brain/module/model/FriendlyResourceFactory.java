/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package org.triple_brain.module.model;

import org.triple_brain.module.model.graph.FriendlyResourceOperator;
import org.triple_brain.module.model.graph.FriendlyResourcePojo;

import java.net.URI;

public interface FriendlyResourceFactory {
    public FriendlyResourceOperator withUri(URI uri);
    public FriendlyResourceOperator createOrLoadUsingPojo(
            FriendlyResourcePojo friendlyResource
    );
}
