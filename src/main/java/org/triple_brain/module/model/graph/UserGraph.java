package org.triple_brain.module.model.graph;

import org.triple_brain.module.model.User;
import org.triple_brain.module.model.graph.exceptions.InvalidDepthOfSubVerticesException;
import org.triple_brain.module.model.graph.exceptions.NonExistingResourceException;

import java.net.URI;

/*
* Copyright Mozilla Public License 1.1
*/
public interface UserGraph {
    public Vertex defaultVertex();
    public User user();
    public Boolean haveElementWithId(URI id);
    public SubGraph graphWithDepthAndCenterVertexId(Integer depthOfSubVertices, URI centerVertexUri) throws NonExistingResourceException;
    public SubGraph graphWithDefaultVertexAndDepth(Integer depth) throws InvalidDepthOfSubVerticesException;
    public String toRdfXml();
    public Vertex vertexWithUri(URI uri);
    public Edge edgeWithUri(URI uri);
    public Vertex createVertex();
}
