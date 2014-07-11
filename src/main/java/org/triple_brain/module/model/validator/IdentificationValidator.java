package org.triple_brain.module.model.validator;

import org.apache.commons.lang.StringUtils;
import org.triple_brain.module.model.graph.Identification;

import java.util.HashSet;
import java.util.Set;

/*
* Copyright Mozilla Public License 1.1
*/
public class IdentificationValidator {

    public static enum IdentificationError {
        EXTERNAL_URI_MANDATORY,
        EMPTY_EXTERNAL_URI
    }

    public Set<IdentificationError> validate(Identification identification){
        Set<IdentificationError> errors = new HashSet<>();
        if(null == identification.getExternalResourceUri()){
            errors.add(
                    IdentificationError.EXTERNAL_URI_MANDATORY
            );
            return errors;
        }
        if(StringUtils.isEmpty(identification.getExternalResourceUri().toString())){
            errors.add(
                    IdentificationError.EMPTY_EXTERNAL_URI
            );
        }
        return errors;
    }
}
