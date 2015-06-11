/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.graph;

import java.net.URI;

public interface IdentificationFactory {
    IdentificationOperator withUri(URI uri);
}
