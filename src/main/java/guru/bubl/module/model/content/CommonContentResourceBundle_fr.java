/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.content;

import java.util.ListResourceBundle;

public class CommonContentResourceBundle_fr extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return contents;
    }
    private static final Object[][] contents = {
            {"task", "tâche"},
            {"taskDesc", ""},
            {"task", "tâche"},
            {"task1", "tâche 1"},
            {"task2", "tâche 2"}
    };
}
