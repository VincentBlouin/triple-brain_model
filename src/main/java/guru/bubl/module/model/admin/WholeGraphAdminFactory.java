/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.admin;

import guru.bubl.module.model.WholeGraph;

public interface WholeGraphAdminFactory {
    WholeGraphAdmin withWholeGraph(WholeGraph wholeGraph);
}
