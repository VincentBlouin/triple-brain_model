/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.content;

import java.util.ListResourceBundle;

public class CommonContentResourceBundle_en extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return contents;
    }
    private static final Object[][] contents = {
            {"task", "task"},
            {"task1", "task 1"},
            {"task2", "task 2"},
            {"taskDesc", "predefined problem with a goal to be achieved"}
    };
}
