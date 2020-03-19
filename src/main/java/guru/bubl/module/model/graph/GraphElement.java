/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.graph;

import guru.bubl.module.model.FriendlyResource;
import guru.bubl.module.model.graph.tag.Tag;
import guru.bubl.module.model.graph.tag.TagPojo;

import java.net.URI;
import java.util.Map;

public interface GraphElement extends FriendlyResource {
    Map<URI, TagPojo> getTags();

    String getFont();

    String getChildrenIndex();

    URI getPatternUri();

    ShareLevel getShareLevel();

    default Boolean isPublic() {
        return this.getShareLevel().isPublic();
    }
}
