package org.triple_brain.module.model.graph.edge;

import java.net.URI;

/*
* Copyright Mozilla Public License 1.1
*/
public interface EdgeFactory {
    EdgeOperator createOrLoadUsingUri(URI uri);
}
