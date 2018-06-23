/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.graph;

import guru.bubl.module.model.ShareLevelGetter;

public interface PublicPrivateOperator extends ShareLevelGetter {
    void makePublic();
    void makePrivate();
}
