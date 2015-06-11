/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.validator;

import org.apache.commons.lang.StringUtils;
import guru.bubl.module.model.graph.Identification;

import java.util.HashSet;
import java.util.Set;

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
