/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.content.movie;

import java.util.ListResourceBundle;

public class MovieContentResourceBundle_en extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return contents;
    }
    private static final Object[][] contents = {
            {"movie", "Movies to watch"}
    };
}
