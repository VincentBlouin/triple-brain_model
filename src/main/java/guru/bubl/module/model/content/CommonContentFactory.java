/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.content;

import java.util.Locale;

public interface CommonContentFactory {
    CommonContent usingLocale(Locale locale);
}
