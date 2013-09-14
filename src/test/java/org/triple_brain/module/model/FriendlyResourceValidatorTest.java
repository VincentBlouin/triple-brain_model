package org.triple_brain.module.model;

import org.codehaus.jettison.json.JSONObject;
import org.junit.Test;
import org.triple_brain.module.model.json.FriendlyResourceJson;
import org.triple_brain.module.model.validator.FriendlyResourceValidator;

import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/*
* Copyright Mozilla Public License 1.1
*/
public class FriendlyResourceValidatorTest {

    @Test
    public void no_errors_when_uri_is_present()throws Exception{
        JSONObject friendlyResource = new JSONObject()
                .put(FriendlyResourceJson.URI, "http://triple-brain.org/asviojasoviasjvoisjv");
        assertFalse(validationWithFriendlyResourceReturnsFieldWithMessage(
                friendlyResource,
                FriendlyResourceJson.URI,
                FriendlyResourceValidator.FriendlyResourceError.URI_MANDATORY
        ));
    }

    @Test
    public void uri_is_mandatory(){
        assertTrue(validationWithFriendlyResourceReturnsFieldWithMessage(
                new JSONObject(),
                FriendlyResourceJson.URI,
                FriendlyResourceValidator.FriendlyResourceError.URI_MANDATORY
        ));
    }

    @Test
    public void uri_has_to_be_valid()throws Exception{
        JSONObject friendlyResource = new JSONObject()
                .put(FriendlyResourceJson.URI, "");
        assertTrue(validationWithFriendlyResourceReturnsFieldWithMessage(
                friendlyResource,
                FriendlyResourceJson.URI,
                FriendlyResourceValidator.FriendlyResourceError.INVALID_URI
        ));
    }

    private boolean validationWithFriendlyResourceReturnsFieldWithMessage(
            JSONObject friendlyResource,
            String field,
            FriendlyResourceValidator.FriendlyResourceError message
    ){
        Map<String, FriendlyResourceValidator.FriendlyResourceError> errors ;
        errors = new FriendlyResourceValidator().validate(
                friendlyResource
        );
        if(errors.get(field) == null){
            return false;
        }
        if(!errors.get(field).equals(message)){
            return false;
        }
        return true;
    }
}
