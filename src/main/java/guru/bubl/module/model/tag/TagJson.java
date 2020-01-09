/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.tag;

import com.google.gson.reflect.TypeToken;
import guru.bubl.module.model.graph.tag.TagPojo;
import guru.bubl.module.model.json.JsonUtils;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.net.URI;
import java.util.Map;
import java.util.Set;

public class TagJson {

    public static String toJson(Map<URI, TagPojo> identifications) {
        return JsonUtils.getGson().toJson(
                identifications
        );
    }

    public static Map<URI, TagPojo> fromJson(String json) {
        return JsonUtils.getGson().fromJson(
                json,
                new TypeToken<Map<URI, TagPojo>>() {
                }.getType()
        );
    }

    public static Set<TagPojo> getSetFromJson(String json) {
        return JsonUtils.getGson().fromJson(
                json,
                new TypeToken<Set<TagPojo>>() {
                }.getType()
        );
    }

    public static String toJsonSet(Set<TagPojo> metas) {
        return JsonUtils.getGson().toJson(
                metas
        );
    }

    public static TagPojo singleFromJson(String json) {
        return JsonUtils.getGson().fromJson(
                json,
                TagPojo.class
        );
    }

    public static JSONObject singleToJson(TagPojo identification) {
        try {
            return new JSONObject(JsonUtils.getGson().toJson(
                    identification
            ));
        }catch(JSONException e){
            throw new RuntimeException(e);
        }
    }

}
