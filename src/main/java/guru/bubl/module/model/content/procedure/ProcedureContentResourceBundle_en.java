/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.content.procedure;

import java.util.ListResourceBundle;

public class ProcedureContentResourceBundle_en extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return contents;
    }
    private static final Object[][] contents = {
            {"procedure_x", "procedure x"},
            {"procedure", "procedure"},
            {"procedureDesc", "defines how to implement one or several activities of a business process, identifies the sequence of steps, and specifies for each step what needs to be done, when, and by whom"},
            {"things", "thing to have"},
            {"thing1", "thing 1"},
            {"thing2", "thing 2"},
            {"step", "step"},
            {"step1", "step 1"},
            {"step2", "step 2"}
    };
}
