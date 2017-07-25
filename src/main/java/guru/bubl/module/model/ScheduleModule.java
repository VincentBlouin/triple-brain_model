/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model;

import guru.bubl.module.model.admin.WholeGraphAdminDailyTask;
import org.nnsoft.guice.guartz.QuartzModule;

public class ScheduleModule extends QuartzModule {

    @Override
    protected void schedule() {
        scheduleJob( WholeGraphAdminDailyTask.class);
    }
}
