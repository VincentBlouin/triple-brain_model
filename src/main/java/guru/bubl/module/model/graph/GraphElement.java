/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.graph;

import guru.bubl.module.model.FriendlyResource;
import guru.bubl.module.model.graph.identification.Identifier;
import guru.bubl.module.model.graph.identification.IdentifierPojo;

import java.net.URI;
import java.util.Map;

public interface GraphElement extends FriendlyResource{
    Map<URI, IdentifierPojo> getIdentifications();

    default Identifier getIdentificationHavingInternalUri(URI uri){
        for(Identifier identification : this.getIdentifications().values()){
            if(identification.uri().equals(uri)){
                return identification;
            }
        }
        return null;
    }
    String getColors();
    String getFont();
    String getChildrenIndex();
    URI getPatternUri();
}
