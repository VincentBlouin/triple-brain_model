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
    VertexOperator defaultVertex();
    User user();
    Boolean haveElementWithId(URI id);
    SubGraphPojo graphWithDepthAndCenterVertexId(Integer depthOfSubVertices, URI centerVertexUri) throws NonExistingResourceException;
    SubGraphPojo graphWithAnyVertexAndDepth(Integer depth) throws InvalidDepthOfSubVerticesException;
    String toRdfXml();
    VertexOperator vertexWithUri(URI uri);
    EdgeOperator edgeWithUri(URI uri);
    SchemaPojo schemaPojoWithUri(URI uri);
    SchemaOperator schemaOperatorWithUri(URI uri);
    VertexPojo createVertex();
    SchemaPojo createSchema();
}
