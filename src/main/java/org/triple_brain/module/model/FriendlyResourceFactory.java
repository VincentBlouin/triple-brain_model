package org.triple_brain.module.model;

import org.triple_brain.module.model.graph.FriendlyResourceOperator;
import org.triple_brain.module.model.graph.FriendlyResourcePojo;

import java.net.URI;

/*
* Copyright Mozilla Public License 1.1
*/
public interface FriendlyResourceFactory {
    public FriendlyResourceOperator createOrLoadFromUri(URI uri);
    public FriendlyResourceOperator createOrLoadUsingUriAndLabel(
            URI uri,
            String label
    );
    public FriendlyResourceOperator createOrLoadUsingPojo(
            FriendlyResourcePojo friendlyResource
    );
}
