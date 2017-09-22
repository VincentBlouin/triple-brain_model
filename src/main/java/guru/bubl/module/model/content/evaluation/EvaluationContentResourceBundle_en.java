/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.content.evaluation;

import java.util.ListResourceBundle;

public class EvaluationContentResourceBundle_en extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return contents;
    }
    private static final Object[][] contents = {
            {"evaluation", "strategic analysis x"},
            {"swot", "SWOT Analysis"},
            {"swotDesc", "strengths, weaknesses, opportunities, threats"},
            {"advantage", "advantage"},
            {"opportunity", "opportunity"},
            {"risk", "risk"},
            {"disadvantage", "disadvantage"}
    };
}
