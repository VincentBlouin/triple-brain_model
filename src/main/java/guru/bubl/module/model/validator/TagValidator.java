/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.validator;

import org.apache.commons.lang.StringUtils;
import guru.bubl.module.model.graph.tag.Tag;

import java.util.HashSet;
import java.util.Set;

public class TagValidator {

    public static enum TagError {
        EXTERNAL_URI_MANDATORY,
        EMPTY_EXTERNAL_URI
    }

    public Set<TagError> validate(Tag identification){
        Set<TagError> errors = new HashSet<>();
        if(null == identification.getExternalResourceUri()){
            errors.add(
                    TagError.EXTERNAL_URI_MANDATORY
            );
            return errors;
        }
        if(StringUtils.isEmpty(identification.getExternalResourceUri().toString())){
            errors.add(
                    TagError.EMPTY_EXTERNAL_URI
            );
        }
        return errors;
    }
}
