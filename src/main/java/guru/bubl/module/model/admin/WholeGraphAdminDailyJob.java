/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.admin;

import javax.inject.Inject;

@javax.inject.Singleton
public class WholeGraphAdminDailyJob {

    @Inject
    private WholeGraphAdmin wholeGraphAdmin;

    public void execute() {
        wholeGraphAdmin.refreshNbNeighborsOfTags();
        wholeGraphAdmin.refreshNbNeighbors();
        wholeGraphAdmin.reindexAll();
    }
}
