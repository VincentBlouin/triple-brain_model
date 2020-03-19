/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.search;

import guru.bubl.module.model.User;

import java.net.URI;
import java.util.List;

public interface GraphSearch {
    static final Integer LIMIT = 10;

    List<GraphElementSearchResult> searchForAllOwnResources(
            User user
    );

    List<GraphElementSearchResult> searchOnlyForOwnVerticesForAutoCompletionByLabel(
            User user
    );

    List<GraphElementSearchResult> searchRelationsForAutoCompletionByLabel(
            User user
    );

    List<GraphElementSearchResult> searchOwnTagsForAutoCompletionByLabel(
            User user
    );

    List<GraphElementSearchResult> searchAllPatterns();

}
