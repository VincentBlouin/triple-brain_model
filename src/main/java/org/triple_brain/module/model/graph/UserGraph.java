package org.triple_brain.module.model.graph;

import org.triple_brain.module.model.User;
import org.triple_brain.module.model.graph.edge.EdgeOperator;
import org.triple_brain.module.model.graph.exceptions.InvalidDepthOfSubVerticesException;
import org.triple_brain.module.model.graph.exceptions.NonExistingResourceException;
import org.triple_brain.module.model.graph.vertex.VertexOperator;

import java.net.URI;

/*
* Copyright Mozilla Public License 1.1
*/
public interface UserGraph {
    public VertexOperator defaultVertex();
    public User user();
    public Boolean haveElementWithId(URI id);
    public SubGraph graphWithDepthAndCenterVertexId(Integer depthOfSubVertices, URI centerVertexUri) throws NonExistingResourceException;
    public SubGraph graphWithDefaultVertexAndDepth(Integer depth) throws InvalidDepthOfSubVerticesException;
    public String toRdfXml();
    public VertexOperator vertexWithUri(URI uri);
    public EdgeOperator edgeWithUri(URI uri);
    public VertexOperator createVertex();
}
