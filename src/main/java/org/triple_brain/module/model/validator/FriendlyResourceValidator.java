package org.triple_brain.module.model.validator;

import org.apache.commons.lang.StringUtils;
import org.triple_brain.module.model.FriendlyResource;

import java.util.HashSet;
import java.util.Set;

/*
* Copyright Mozilla Public License 1.1
*/
public class FriendlyResourceValidator {

    public static enum FriendlyResourceError {
        URI_MANDATORY,
        EMPTY_URI
    }

    public Set<FriendlyResourceError> validate(FriendlyResource friendlyResource){
        Set<FriendlyResourceError> errors = new HashSet<>();
        if(null == friendlyResource.uri()){
            errors.add(
                    FriendlyResourceError.URI_MANDATORY
            );
            return errors;
        }
        if(StringUtils.isEmpty(friendlyResource.uri().toString())){
            errors.add(
                    FriendlyResourceError.EMPTY_URI
            );
        }
        return errors;
    }
}
