package org.triple_brain.module.model.validator;

import org.apache.commons.lang.StringUtils;
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
        EMPTY_URI
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
        if(StringUtils.isEmpty(uri)){
            errors.put(
                    FriendlyResourceJson.URI,
                    FriendlyResourceError.EMPTY_URI
            );
        }
        return errors;
    }
}
