package org.triple_brain.module.model.graph;

import java.net.URI;

/*
* Copyright Mozilla Public License 1.1
*/
public interface EdgeFactory {
    Edge createOrLoadUsingUri(URI uri);
}
