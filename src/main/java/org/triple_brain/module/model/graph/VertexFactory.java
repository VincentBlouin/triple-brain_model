package org.triple_brain.module.model.graph;

import java.net.URI;
import java.util.Set;

/*
* Copyright Mozilla Public License 1.1
*/
public interface VertexFactory {
    public VertexInSubGraph createOrLoadUsingUri(URI uri);
    public VertexInSubGraph createForOwnerUsername(String username);
    public VertexInSubGraph createFromVertices(Set<Vertex> vertices);
}
