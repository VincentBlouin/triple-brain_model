/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.center_graph_element;

import guru.bubl.module.model.User;

import java.util.List;

public interface CenteredGraphElementsOperator {

    List<CenterGraphElementPojo> getPublicAndPrivateForOwner(User owner);

    List<CenterGraphElementPojo> getAllPublic();

    List<CenterGraphElementPojo> getPublicOfUser(User owner);

    List<CenterGraphElementPojo> getAllPatterns();

    List<CenterGraphElementPojo> getFriendsFeedForUser(User user);

    List<CenterGraphElementPojo> getForAFriend(User friend);

}
