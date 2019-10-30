/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.search;

import com.google.inject.assistedinject.Assisted;
import guru.bubl.module.model.center_graph_element.CenteredGraphElementsOperator;

public interface GraphSearchFactory {
    GraphSearch usingSearchTermSkipAndLimit(
            String searchTerm,
            @Assisted("skip") Integer skip,
            @Assisted("limit") Integer limit
    );

    GraphSearch usingSearchTerm(String searchTerm);
}
