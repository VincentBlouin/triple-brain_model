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
    public Boolean haveElementWithId(String id);
    public SubGraph graphWithDepthAndCenterVertexId(Integer depthOfSubVertices, String centerVertexURI) throws NonExistingResourceException;
    public SubGraph graphWithDefaultVertexAndDepth(Integer depth) throws InvalidDepthOfSubVerticesException;
    public String toRdfXml();
    public Vertex vertexWithURI(URI uri);
    public Edge edgeWithUri(URI uri);
}
