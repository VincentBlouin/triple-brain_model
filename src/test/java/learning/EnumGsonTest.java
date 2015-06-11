/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package learning;

import com.google.gson.Gson;
import org.codehaus.jettison.json.JSONObject;
import org.junit.Test;
import guru.bubl.module.model.graph.GraphElementType;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class EnumGsonTest {

    @Test
    public void enum_are_included_in_gson_conversion()throws Exception{
        JSONObject json = new JSONObject(
                new Gson().toJson(new WithEnum())
        );
        assertThat(
                GraphElementType.valueOf(
                        json.getString("type")
                ),
                is(GraphElementType.edge)
        );
    }

    private class WithEnum{
        private GraphElementType type = GraphElementType.edge;
    }

}
