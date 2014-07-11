package org.triple_brain.module.model.graph;

import org.triple_brain.module.model.FriendlyResource;

import java.net.URI;

/*
* Copyright Mozilla Public License 1.1
*/
public interface Identification extends FriendlyResource {
    URI getExternalResourceUri();
}
