/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.center_graph_element;

import java.util.Set;

public interface CenteredGraphElementsOperator {
    Set<CenterGraphElementPojo> getPublicAndPrivate();

    Set<CenterGraphElementPojo> getPublicAndPrivateWithLimitAndSkip(Integer limit, Integer skip);

    Set<CenterGraphElementPojo> getPublicOnlyOfType();

    Set<CenterGraphElementPojo> getPublicOnlyOfTypeWithLimitAndSkip(Integer limit, Integer skip);
}
