/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.graph.tag;

import java.net.URI;

public interface TagFactory {
    TagOperator withUri(URI uri);
}
