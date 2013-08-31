package org.triple_brain.module.model.json;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.triple_brain.module.model.FriendlyResource;
/*
* Copyright Mozilla Public License 1.1
*/
public class ExternalResourceJson {
    public static final String URI = "uri";
    public static final String LABEL = "label";
    public static final String IMAGES = "images";
    public static final String DESCRIPTION = "description";

    public static JSONObject get(FriendlyResource resource) {
        try {
            return new JSONObject()
                    .put(URI, resource.uri())
                    .put(LABEL, resource.label())
                    .put(IMAGES, ImageJson.fromCollection(
                            resource.images()
                    ))
                    .put(DESCRIPTION, resource.description());
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
