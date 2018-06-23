/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model;

import guru.bubl.module.model.graph.ShareLevel;

public interface ShareLevelGetter {
    Boolean isPublic();
    ShareLevel getShareLevel();
}
