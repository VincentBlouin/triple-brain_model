/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.graph;

import guru.bubl.module.model.FriendlyResource;

import java.net.URI;
import java.util.Map;

public interface GraphElement extends FriendlyResource, Identification{
    Map<URI, ?extends Identification> getGenericIdentifications();
    Map<URI, ?extends Identification> getSameAs();
    Map<URI, ?extends Identification> getAdditionalTypes();
    Map<URI, ?extends Identification> getIdentifications();
}
