/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.meta;

import guru.bubl.module.model.User;

public interface UserMetasOperatorFactory {
    UserMetasOperator forUser(User user);
}
