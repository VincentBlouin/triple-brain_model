/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.friend.friend_confirmation_email;

import java.util.ListResourceBundle;

public class FriendConfirmationResourceBundle_fr extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return contents;
    }
    static final Object[][] contents = {
            {"subject", "a accepté votre requête d'ami"},
            {"body", "Vous pouvez maintenant voir plus de ses bulles à partir ce lien"}
    };
}
