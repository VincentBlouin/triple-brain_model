/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.graph;

import guru.bubl.module.model.graph.schema.SchemaOperator;
import guru.bubl.module.model.User;
import guru.bubl.module.model.graph.edge.EdgeOperator;
import guru.bubl.module.model.graph.exceptions.InvalidDepthOfSubVerticesException;
import guru.bubl.module.model.graph.exceptions.NonExistingResourceException;
import guru.bubl.module.model.graph.schema.SchemaPojo;
import guru.bubl.module.model.graph.vertex.VertexOperator;
import guru.bubl.module.model.graph.vertex.VertexPojo;

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
