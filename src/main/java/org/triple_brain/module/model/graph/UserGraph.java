/*
 * Copyright Vincent Blouin under the Mozilla Public License 1.1
 */

package org.triple_brain.module.model.graph;

import org.triple_brain.module.model.User;
import org.triple_brain.module.model.graph.edge.EdgeOperator;
import org.triple_brain.module.model.graph.exceptions.InvalidDepthOfSubVerticesException;
import org.triple_brain.module.model.graph.exceptions.NonExistingResourceException;
import org.triple_brain.module.model.graph.schema.SchemaOperator;
import org.triple_brain.module.model.graph.schema.SchemaPojo;
import org.triple_brain.module.model.graph.vertex.VertexOperator;
import org.triple_brain.module.model.graph.vertex.VertexPojo;

import java.net.URI;

public interface UserGraph {
    public VertexOperator defaultVertex();
    public User user();
    public Boolean haveElementWithId(URI id);
    public SubGraphPojo graphWithDepthAndCenterVertexId(Integer depthOfSubVertices, URI centerVertexUri) throws NonExistingResourceException;
    public SubGraphPojo graphWithDefaultVertexAndDepth(Integer depth) throws InvalidDepthOfSubVerticesException;
    public String toRdfXml();
    public VertexOperator vertexWithUri(URI uri);
    public EdgeOperator edgeWithUri(URI uri);
    public SchemaPojo schemaPojoWithUri(URI uri);
    public SchemaOperator schemaOperatorWithUri(URI uri);
    public VertexPojo createVertex();
    public SchemaPojo createSchema();
}
