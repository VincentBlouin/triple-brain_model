/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.admin;

public interface WholeGraphAdmin {

    void refreshNbNeighbors();

    void refreshNbNeighborsToAllTags();

    void reindexAll();

}
