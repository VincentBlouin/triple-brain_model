package org.triple_brain.module.model.graph;

import java.net.URI;
import java.util.Set;

/*
* Copyright Mozilla Public License 1.1
*/
public interface VertexFactory {
    VertexInSubGraph createOrLoadUsingUri(URI uri);
    VertexInSubGraph createForOwnerUsername(String username);
    VertexInSubGraph createFromVertices(Set<Vertex> vertices);
}
