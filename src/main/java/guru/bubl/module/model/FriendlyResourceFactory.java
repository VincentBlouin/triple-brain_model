/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model;

import guru.bubl.module.model.graph.FriendlyResourceOperator;
import guru.bubl.module.model.graph.FriendlyResourcePojo;

import java.net.URI;

public interface FriendlyResourceFactory {
    public FriendlyResourceOperator withUri(URI uri);
    public FriendlyResourceOperator createOrLoadUsingPojo(
            FriendlyResourcePojo friendlyResource
    );
}
