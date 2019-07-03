/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.center_graph_element;

import java.util.Set;

public interface CenteredGraphElementsOperator{
    Set<CenterGraphElementPojo> getPublicAndPrivate();
    Set<CenterGraphElementPojo> getPublicAndPrivateWithLimit(Integer limit);
    Set<CenterGraphElementPojo> getPublicOnlyOfType();
    Set<CenterGraphElementPojo> getPublicOnlyOfTypeWithLimit(Integer limit);
    void removeCenterGraphElements(Set<CenterGraphElementPojo> centers);
}
