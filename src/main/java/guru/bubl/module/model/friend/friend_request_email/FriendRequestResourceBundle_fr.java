/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.friend.friend_request_email;

import java.util.ListResourceBundle;

public class FriendRequestResourceBundle_fr extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return contents;
    }
    static final Object[][] contents = {
            {"subject", "veut être votre ami"},
            {"body", "Suivez ce lien pour accepter sa requête d'amitié"}
    };
}
