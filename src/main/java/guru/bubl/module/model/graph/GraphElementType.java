/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.graph;

public enum GraphElementType {
    resource,
    vertex,
    edge,
    schema,
    property,
    meta;

    public static String[] names() {
        GraphElementType[] types = values();
        String[] names = new String[types.length];

        for (int i = 0; i < types.length; i++) {
            names[i] = types[i].name();
        }

        return names;
    }
}
