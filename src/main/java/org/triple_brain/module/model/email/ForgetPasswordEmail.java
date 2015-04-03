/*
 * Copyright Vincent Blouin under the Mozilla Public License 1.1
 */

package org.triple_brain.module.model.email;

import org.triple_brain.module.model.User;

import javax.mail.Message;

public interface ForgetPasswordEmail {
    Message send(User user);
}
