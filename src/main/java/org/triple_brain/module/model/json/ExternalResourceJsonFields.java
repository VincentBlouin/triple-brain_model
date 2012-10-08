package org.triple_brain.module.model.json;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.triple_brain.module.common_utils.Uris;
import org.triple_brain.module.common_utils.Urls;
import org.triple_brain.module.model.ExternalFriendlyResource;
import java.net.URI;
/*
* Copyright Mozilla Public License 1.1
*/
public class ExternalResourceJsonFields {
    public static final String URI = "uri";
    public static final String LABEL = "label";
    public static final String IMAGE_URL = "image_url";

    public static JSONObject toJson(ExternalFriendlyResource externalResource) {
        try {
            String imageUrl = externalResource.hasImageUrl() ?
                    externalResource.imageUrl().toString() :
                    null;
            return new JSONObject()
                    .put(URI, externalResource.uri())
                    .put(LABEL, externalResource.label())
                    .put(IMAGE_URL, imageUrl);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public static ExternalFriendlyResource fromJson(JSONObject externalResource){
        try{
            URI uri = Uris.get(
                    externalResource.getString(
                            ExternalResourceJsonFields.URI
                    )
            );
            String label = externalResource.getString(
                    ExternalResourceJsonFields.LABEL
            );
            return externalResource.has(ExternalResourceJsonFields.IMAGE_URL) ?
                    ExternalFriendlyResource.withUriLabelAndImageUrl(
                            uri,
                            label,
                            Urls.get(
                                    externalResource.getString(
                                            ExternalResourceJsonFields.IMAGE_URL
                                    )
                            )
                    ) :
                    ExternalFriendlyResource.withUriAndLabel(
                            uri,
                            label
                    );
        }catch(JSONException e){
            throw new RuntimeException(e);
        }
    }
}
