/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.graph;

import guru.bubl.module.model.FriendlyResource;
import guru.bubl.module.model.graph.identification.Identification;
import guru.bubl.module.model.graph.identification.IdentificationPojo;

import java.net.URI;
import java.util.Date;
import java.util.Map;

public interface GraphElement extends FriendlyResource{
    Map<URI, IdentificationPojo> getGenericIdentifications();
    Map<URI, IdentificationPojo> getSameAs();
    Map<URI, IdentificationPojo> getAdditionalTypes();
    Map<URI, IdentificationPojo> getIdentifications();

    default Identification getIdentificationHavingInternalUri(URI uri){
        for(Identification identification : this.getIdentifications().values()){
            if(identification.uri().equals(uri)){
                return identification;
            }
        }
        return null;
    }
}
