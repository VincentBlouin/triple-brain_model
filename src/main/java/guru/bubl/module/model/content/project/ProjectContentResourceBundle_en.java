/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.content.project;

import java.util.ListResourceBundle;

public class ProjectContentResourceBundle_en extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return contents;
    }
    private static final Object[][] contents = {
            {"project", "a project"},
            {"strategy", "strategy"},
            {"strategyDesc", "high level plan to achieve objectives in uncertain conditions"},
            {"definitionAndVision", "definition and vision"},
            {"history", "history"},
            {"historyDesc", "umbrella term covering the record of past events"},
            {"objectAndInfrastructure", "objects and infrastructures"},
            {"communication", "communication"}
    };
}
