/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.content.project;

import java.util.ListResourceBundle;

public class ProjectContentResourceBundle_fr extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return contents;
    }
    private static final Object[][] contents = {
            {"project", "un projet"},
            {"strategy", "stratégie"},
            {"strategyDesc", "un « ensemble d'actions coordonnées, d'opérations habiles, de manœuvres en vue d'atteindre un but précis »."},
            {"definitionAndVision", "définition et vision"},
            {"history", "histoire"},
            {"historyDesc", "étude des faits et des événements du passé"},
            {"objectAndInfrastructure", "objets et infrastructures"},
            {"communication", "communication"}
    };
}
