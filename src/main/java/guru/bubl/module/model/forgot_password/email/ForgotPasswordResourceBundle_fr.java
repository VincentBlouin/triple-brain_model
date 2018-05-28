/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.forgot_password.email;

import java.util.ListResourceBundle;

public class ForgotPasswordResourceBundle_fr extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return contents;
    }
    static final Object[][] contents = {
            {"subject", "Modifier son mot de passe"},
            {"body", "Suivez ce lien pour modifier votre mot de passe"}
    };
}
