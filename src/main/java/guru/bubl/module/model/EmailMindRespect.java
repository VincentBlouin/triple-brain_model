/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model;

import com.google.inject.Inject;
import com.sendgrid.*;
import guru.bubl.module.common_utils.NoEx;

public class EmailMindRespect {

    @Inject
    SendGrid sendgrid;

    public static final com.sendgrid.Email FROM = new com.sendgrid.Email(
            "mindrespect.com <no-reply@mindrespect.com>"
    );

    public Response send(Mail mail) {
        return NoEx.wrap(() -> {
            Request request = new Request();
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            return sendgrid.api(request);
        }).get();
    }
}
