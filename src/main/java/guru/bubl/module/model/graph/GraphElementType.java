/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.graph;

public enum GraphElementType {
    resource,
    vertex,
    edge,
    schema,
    property;

    public static String[] names() {
        GraphElementType[] states = values();
        String[] names = new String[states.length];

        for (int i = 0; i < states.length; i++) {
            names[i] = states[i].name();
        }

        return names;
    }
}
