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
    Meta,
    Pattern,
    GroupRelation,
    Unknown;

    public static List<GraphElementType> commonTypes = Arrays.asList(new GraphElementType[]{GraphElementType.Resource, GraphElementType.GraphElement, GraphElementType.Pattern});

    public static String[] names() {
        GraphElementType[] types = values();
        String[] names = new String[types.length];

        for (int i = 0; i < types.length; i++) {
            names[i] = types[i].name();
        }

        return names;
    }
}
