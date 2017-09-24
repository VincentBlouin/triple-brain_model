/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.content.procedure;

import java.util.ListResourceBundle;

public class ProcedureContentResourceBundle_fr extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        return contents;
    }

    private static final Object[][] contents = {
            {"procedure_x", "procédure pour ..."},
            {"procedure", "procédure"},
            {"procedureDesc", "description de l'exécution, du savoir-faire d'une compétence"},
            {"things", "chose à avoir"},
            {"thing1", "chose 1"},
            {"thing2", "chose 2"},
            {"step", "étape"},
            {"step1", "étape 1"},
            {"step2", "étape 2"}
    };
}

