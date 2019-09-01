/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.graph;

import java.util.Arrays;
import java.util.List;

public enum GraphElementType {
    Resource,
    GraphElement,
    Vertex,
    Edge,
    Schema,
    Property,
    Meta;

    public static List<GraphElementType> commonTypes = Arrays.asList(new GraphElementType[]{GraphElementType.Resource, GraphElementType.GraphElement});

    public static String[] names() {
        GraphElementType[] types = values();
        String[] names = new String[types.length];

        for (int i = 0; i < types.length; i++) {
            names[i] = types[i].name();
        }

        return names;
    }
}
