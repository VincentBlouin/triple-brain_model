/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.center_graph_element;

import java.util.Date;

public interface CenterGraphElementOperator {
    void incrementNumberOfVisits();
    Integer getNumberOfVisits();
    void updateLastCenterDate();
    void setLastCenterDate(Date lastCenterDate);
    Date getLastCenterDate();
    void remove();
}
