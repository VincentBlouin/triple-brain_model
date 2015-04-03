/*
 * Copyright Vincent Blouin under the Mozilla Public License 1.1
 */

package org.triple_brain.module.model.email.forget_password;

import java.util.ListResourceBundle;

public class ForgetPasswordResourceBundle_fr extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return contents;
    }
    static final Object[][] contents = {
            {"body", "Suivez ce lien pour mettre à jour votre mot de passe"}
    };
}
