/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package learning;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import guru.bubl.module.model.json.JsonUtils;
import org.codehaus.jettison.json.JSONObject;
import org.junit.Test;
import guru.bubl.module.model.graph.graph_element.GraphElementType;

import java.net.URI;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class GsonTest {

    @Test
    public void enum_are_included_in_gson_conversion() throws Exception {
        JSONObject json = new JSONObject(
                new Gson().toJson(new WithEnum())
        );
        assertThat(
                GraphElementType.valueOf(
                        json.getString("type")
                ),
                is(GraphElementType.Edge)
        );
    }

    @Test
    public void escapes_strings() {
        Set<String> strings = new HashSet<>();
        strings.add("\"some\" string with quotes");
        String jsonString = JsonUtils.getGson().toJson(strings);
        Set<String> stringsFromJson = JsonUtils.getGson().fromJson(
                jsonString,
                new TypeToken<Set<String>>() {
                }.getType()
        );
        assertThat(
                stringsFromJson.iterator().next(),
                is("\"some\" string with quotes")
        );
    }

    @Test
    public void escapes_strings_in_hash_map() {
        Map<URI, String> strings = new HashMap<>();
        strings.put(
                URI.create("/"),
                "\"some\" string with quotes");
        String jsonString = JsonUtils.getGson().toJson(strings);
        Map<URI, String> stringsFromJson = JsonUtils.getGson().fromJson(
                jsonString,
                new TypeToken<HashMap<URI, String>>() {
                }.getType()
        );
        assertThat(
                stringsFromJson.values().iterator().next(),
                is("\"some\" string with quotes")
        );
    }

    private class WithEnum {
        private GraphElementType type = GraphElementType.Edge;
    }

}
