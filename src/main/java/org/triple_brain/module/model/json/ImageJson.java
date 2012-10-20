package org.triple_brain.module.model.json;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.triple_brain.module.model.Image;

import java.util.Collection;

/*
* Copyright Mozilla Public License 1.1
*/
public class ImageJson {

    public static final String SMALL_IMAGE_URL_KEY = "small_image_url";
    public static final  String BIGGER_IMAGE_URL_KEY = "bigger_image_url";

    public static JSONArray fromCollection(Collection<Image> images){
        JSONArray jsonArray = new JSONArray();
        for(Image image : images){
            jsonArray.put(get(image));
        }
        return jsonArray;
    }

    private static JSONObject get(Image image){
        try{
            return new JSONObject()
                    .put(
                            SMALL_IMAGE_URL_KEY,
                            image.urlForSmall()
                    )
                    .put(
                            BIGGER_IMAGE_URL_KEY,
                            image.urlForBigger()
                    );
        }catch(JSONException e){
            throw new RuntimeException(e);
        }
    }
}
