package org.triple_brain.module.model.json;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.triple_brain.module.model.ExternalFriendlyResource;

/*
* Copyright Mozilla Public License 1.1
*/
public class ExternalResourceJsonFields {
    public static final String URI = "uri";
    public static final String LABEL = "label";

    public static JSONObject toJson(ExternalFriendlyResource externalResource) {
        try {
            return new JSONObject()
                    .put(URI, externalResource.uri())
                    .put(LABEL, externalResource.label());
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
