package org.triple_brain.module.model.json;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.triple_brain.module.common_utils.Uris;
import org.triple_brain.module.model.ExternalFriendlyResource;

import java.net.URI;
/*
* Copyright Mozilla Public License 1.1
*/
public class ExternalResourceJson {
    public static final String URI = "uri";
    public static final String LABEL = "label";
    public static final String IMAGES = "images";
    public static final String DESCRIPTION = "description";

    public static JSONObject get(ExternalFriendlyResource externalResource) {
        try {
            return new JSONObject()
                    .put(URI, externalResource.uri())
                    .put(LABEL, externalResource.label())
                    .put(IMAGES, ImageJson.fromCollection(
                            externalResource.images()
                    ))
                    .put(DESCRIPTION, externalResource.description());
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public static ExternalFriendlyResource fromJson(JSONObject externalResource){
        try{
            URI uri = Uris.get(
                    externalResource.getString(
                            ExternalResourceJson.URI
                    )
            );
            String label = externalResource.getString(
                    ExternalResourceJson.LABEL
            );
            return ExternalFriendlyResource.withUriLabelAndDescription(
                    uri,
                    label,
                    externalResource.getString(DESCRIPTION)
            );
        }catch(JSONException e){
            throw new RuntimeException(e);
        }
    }
}
