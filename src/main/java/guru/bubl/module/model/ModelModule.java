/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model;

import com.google.inject.AbstractModule;
import guru.bubl.module.model.forgot_password.email.ForgotPasswordEmailImpl;
import guru.bubl.module.model.forgot_password.email.ForgotPasswordEmail;

import javax.inject.Singleton;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class ModelModule extends AbstractModule{

    private Boolean isTesting;

    public static ModelModule forTesting(){
        return new ModelModule(
                true
        );
    }

    public ModelModule(){
        this(false);
    }

    public ModelModule(Boolean isTesting){
        this.isTesting = isTesting;
    }

    @Override
    protected void configure() {
        if(isTesting){
            testBinding();
        }else{
            nonTestBinding();
        }
    }

    private void testBinding(){
        bind(ForgotPasswordEmail.class).toInstance(new ForgotPasswordEmail() {
            @Override
            public Message send(User user, String resetUrl) {
                return new MimeMessage(
                        Session.getDefaultInstance(
                                new Properties(),
                                null
                        )
                );
            }
        });
    }

    private void nonTestBinding(){
        bind(ForgotPasswordEmail.class).to(ForgotPasswordEmailImpl.class).in(Singleton.class);
    }
}
