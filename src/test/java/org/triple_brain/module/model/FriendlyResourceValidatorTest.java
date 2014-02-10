package org.triple_brain.module.model;

import com.google.gson.Gson;
import org.codehaus.jettison.json.JSONObject;
import org.junit.Test;
import org.triple_brain.module.model.graph.FriendlyResourcePojo;
import org.triple_brain.module.model.validator.FriendlyResourceValidator;

import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/*
* Copyright Mozilla Public License 1.1
*/
public class FriendlyResourceValidatorTest {

    private Gson gson = new Gson();

    private enum fields{
        uri
    };

    @Test
    public void no_errors_when_uri_is_present()throws Exception{
        JSONObject friendlyResource = new JSONObject().put(
                fields.uri.name(),
                "http://triple-brain.org/asviojasoviasjvoisjv"
        );
        assertFalse(validationWithJsonReturnsMessage(
                friendlyResource,
                FriendlyResourceValidator.FriendlyResourceError.URI_MANDATORY
        ));
    }

    @Test
    public void uri_is_mandatory(){
        assertTrue(validationWithJsonReturnsMessage(
                new JSONObject(),
                FriendlyResourceValidator.FriendlyResourceError.URI_MANDATORY
        ));
    }

    @Test
    public void uri_has_to_be_valid()throws Exception{
        JSONObject friendlyResource = new JSONObject()
                .put(
                        fields.uri.name(),
                        ""
                );
        assertTrue(validationWithJsonReturnsMessage(
                friendlyResource,
                FriendlyResourceValidator.FriendlyResourceError.EMPTY_URI
        ));
    }

    @Test
    public void can_have_relative_uris()throws Exception{
        JSONObject json = new JSONObject()
                .put(
                        fields.uri.name(),
                        "/service/users/vince/graph/edge/c30bbev5-0c1f-4b08-b600-fb6040abb7eq/identification"
                );
        FriendlyResourceValidator validator = new FriendlyResourceValidator();
        FriendlyResource friendlyResource = gson.fromJson(
                json.toString(),
                FriendlyResourcePojo.class
        );
        assertTrue(
                validator.validate(
                        friendlyResource
                ).isEmpty()
        );
    }

    private boolean validationWithJsonReturnsMessage(
            JSONObject json,
            FriendlyResourceValidator.FriendlyResourceError message
    ){
        Set<FriendlyResourceValidator.FriendlyResourceError> errors ;
        errors = new FriendlyResourceValidator().validate(
                friendlyResourceFromJson(json)
        );
        return errors.contains(message);
    }

    private FriendlyResource friendlyResourceFromJson(JSONObject jsonObject){
        return gson.fromJson(
                jsonObject.toString(),
                FriendlyResourcePojo.class
        );
    }
}
