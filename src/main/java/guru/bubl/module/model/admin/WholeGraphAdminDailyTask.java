/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.admin;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import javax.inject.Inject;

@javax.inject.Singleton
@org.nnsoft.guice.guartz.Scheduled(jobName = "admin task", cronExpression = "0 0 2 * * ?")
public class WholeGraphAdminDailyTask implements org.quartz.Job {

    @Inject
    private WholeGraphAdmin wholeGraphAdmin;

    public void execute(JobExecutionContext context) throws JobExecutionException {
        wholeGraphAdmin.reindexAll();
        wholeGraphAdmin.refreshNumberOfReferencesToAllIdentifications();
        wholeGraphAdmin.removeMetasHavingZeroReferences();
        wholeGraphAdmin.refreshNumberOfConnectedEdges();
    }
}
