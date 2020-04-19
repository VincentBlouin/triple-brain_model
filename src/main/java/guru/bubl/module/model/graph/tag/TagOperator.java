/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.graph.tag;

import guru.bubl.module.model.graph.graph_element.GraphElementOperator;
import guru.bubl.module.model.graph.fork.ForkOperator;

import java.net.URI;

public interface TagOperator extends Tag, ForkOperator, GraphElementOperator {
    void setExternalResourceUri(URI uri);

    TagPojo buildPojo();

    void mergeTo(Tag tag);
}
