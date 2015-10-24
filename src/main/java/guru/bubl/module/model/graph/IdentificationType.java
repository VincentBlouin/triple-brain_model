/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.graph;

public enum IdentificationType {
    generic,
    type,
    same_as;

    public static String[] names() {
        IdentificationType[] types = values();
        String[] names = new String[types.length];

        for (int i = 0; i < types.length; i++) {
            names[i] = types[i].name();
        }

        return names;
    }
}
