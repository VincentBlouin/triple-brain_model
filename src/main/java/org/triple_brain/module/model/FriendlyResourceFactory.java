package org.triple_brain.module.model;

import org.codehaus.jettison.json.JSONObject;
import org.triple_brain.module.model.graph.FriendlyResourceOperator;

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
    public FriendlyResourceOperator createOrLoadUsingJson(
            JSONObject json
    );
}
