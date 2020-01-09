/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.tag;

import guru.bubl.module.model.User;

public interface UserTagsOperatorFactory {
    UserTagsOperator forUser(User user);
}
