/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.graph;

import guru.bubl.module.model.PublicPrivateElement;

public interface PublicPrivateOperator extends PublicPrivateElement {
    void makePublic();
    void makePrivate();
}
