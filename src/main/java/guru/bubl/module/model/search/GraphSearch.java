/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.search;

import guru.bubl.module.model.User;

import java.net.URI;
import java.util.List;

public interface GraphSearch {
    List<GraphElementSearchResult> searchForAllOwnResources(
            String searchTerm,
            User user
    );

    List<GraphElementSearchResult> searchForAnyResourceThatCanBeUsedAsAnIdentifier(
            String searchTerm,
            User user
    );

    List<GraphElementSearchResult> searchOnlyForOwnVerticesOrSchemasForAutoCompletionByLabel(
            String label, User user
    );

    List<GraphElementSearchResult> searchOnlyForOwnVerticesForAutoCompletionByLabel(
            String searchTerm, User user
    );
    List<GraphElementSearchResult> searchRelationsPropertiesSchemasForAutoCompletionByLabel(
            String searchTerm,
            User user
    );
    GraphElementSearchResult getDetails(URI uri, User user);

    List<GraphElementSearchResult> searchPublicVerticesOnly(
            String searchTerm
    );

    GraphElementSearchResult getDetailsAnonymously(URI uri);

}
