/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.forgot_password.email;

import java.util.ListResourceBundle;

public class ForgotPasswordResourceBundle_en extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return contents;
    }
    static final Object[][] contents = {
            {"subject", "mindrespect.com password reset"},
            {"body", "Follow this link to reset your password"}
    };
}
