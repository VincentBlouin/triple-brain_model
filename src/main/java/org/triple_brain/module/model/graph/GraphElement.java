package org.triple_brain.module.model.graph;

import org.triple_brain.module.model.FriendlyResource;

import java.net.URI;
import java.util.Map;
import java.util.Set;

/**
 * Copyright Mozilla Public License 1.1
 */
public interface GraphElement extends FriendlyResource{
    Map<URI, ?extends FriendlyResource> getGenericIdentifications();
    Map<URI, ?extends FriendlyResource> getSameAs();
    Map<URI, ?extends FriendlyResource> getAdditionalTypes();
    Map<URI, ?extends FriendlyResource> getIdentifications();
    String ownerUsername();
}
