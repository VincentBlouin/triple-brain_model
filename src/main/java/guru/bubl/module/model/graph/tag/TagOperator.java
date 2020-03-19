/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.graph.tag;

import guru.bubl.module.model.graph.GraphElementOperator;
import guru.bubl.module.model.graph.ShareLevel;
import guru.bubl.module.model.graph.vertex.VertexTypeOperator;

import java.net.URI;

public interface TagOperator extends Tag, VertexTypeOperator, GraphElementOperator {
    void setExternalResourceUri(URI uri);

    TagPojo buildPojo();

    void mergeTo(Tag tag);
}
