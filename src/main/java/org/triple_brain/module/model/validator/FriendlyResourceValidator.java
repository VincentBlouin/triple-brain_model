package org.triple_brain.module.model.validator;

import org.apache.commons.validator.routines.UrlValidator;
import org.codehaus.jettison.json.JSONObject;
import org.triple_brain.module.model.json.FriendlyResourceJson;

import java.util.LinkedHashMap;
import java.util.Map;

/*
* Copyright Mozilla Public License 1.1
*/
public class FriendlyResourceValidator {

    public static enum FriendlyResourceError {
        URI_MANDATORY,
        INVALID_URI
    }

    public Map<String, FriendlyResourceError> validate(JSONObject friendlyResource){
        Map<String, FriendlyResourceError> errors = new LinkedHashMap<>();
        if(!friendlyResource.has(FriendlyResourceJson.URI)){
            errors.put(
                    FriendlyResourceJson.URI,
                    FriendlyResourceError.URI_MANDATORY
            );
            return errors;
        }
        String uri = friendlyResource.optString(FriendlyResourceJson.URI);
        UrlValidator urlValidator = new UrlValidator();
        if(!urlValidator.isValid(uri)){
            errors.put(
                    FriendlyResourceJson.URI,
                    FriendlyResourceError.INVALID_URI
            );
        }
        return errors;
    }
}
