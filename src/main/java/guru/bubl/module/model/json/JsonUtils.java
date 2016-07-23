/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonUtils {
    public static Gson getGson(){
        return new GsonBuilder().setDateFormat(
                "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
        ).create();
    }
}
