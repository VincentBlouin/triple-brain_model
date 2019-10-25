/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.center_graph_element;

import com.google.inject.assistedinject.Assisted;

public interface CenterGraphElementsOperatorFactory {
    CenteredGraphElementsOperator usingLimitAndSkip(
            @Assisted("limit") Integer limit,
            @Assisted("skip") Integer skip
    );
    CenteredGraphElementsOperator usingDefaultLimits();
}
