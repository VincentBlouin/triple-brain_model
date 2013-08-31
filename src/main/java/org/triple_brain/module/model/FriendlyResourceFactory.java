package org.triple_brain.module.model;

import org.codehaus.jettison.json.JSONObject;

import java.net.URI;

/*
* Copyright Mozilla Public License 1.1
*/
public interface FriendlyResourceFactory {
    public FriendlyResource createOrLoadFromUri(URI uri);
    public FriendlyResource createOrLoadUsingUriAndLabel(
            URI uri,
            String label
    );
    public FriendlyResource createOrLoadUsingJson(
            JSONObject json
    );
}
