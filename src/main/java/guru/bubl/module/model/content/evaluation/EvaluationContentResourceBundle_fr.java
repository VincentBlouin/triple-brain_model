/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.content.evaluation;

import java.util.ListResourceBundle;

public class EvaluationContentResourceBundle_fr extends ListResourceBundle{
    @Override
    protected Object[][] getContents() {
        return contents;
    }
    private static final Object[][] contents = {
            {"evaluation", "analyse stratégique de ..."},
            {"swot", "Analyse FFOM"},
            {"swotDesc", "forces, faiblesses, opportunités, menaces"},
            {"advantage", "avantage"},
            {"opportunity", "opportunité"},
            {"risk", "risque"},
            {"disadvantage", "désavantage"}
    };
}
