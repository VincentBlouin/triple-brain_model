/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.graph.subgraph;

import guru.bubl.module.model.User;
import guru.bubl.module.model.graph.ShareLevel;
import guru.bubl.module.model.graph.edge.EdgeOperator;
import guru.bubl.module.model.graph.exceptions.InvalidDepthOfSubVerticesException;
import guru.bubl.module.model.graph.exceptions.NonExistingResourceException;
import guru.bubl.module.model.graph.schema.SchemaOperator;
import guru.bubl.module.model.graph.schema.SchemaPojo;
import guru.bubl.module.model.graph.vertex.VertexOperator;
import guru.bubl.module.model.graph.vertex.VertexPojo;

import java.net.URI;
import java.util.Set;

public interface UserGraph {
    VertexOperator defaultVertex();
    User user();
    Boolean haveElementWithId(URI id);
    SubGraphPojo graphWithDepthAndCenterBubbleUri(Integer depthOfSubVertices, URI centerVertexUri) throws NonExistingResourceException;
    SubGraphPojo aroundVertexUriInShareLevels(URI centerVertexUri, Integer... shareLevels) throws NonExistingResourceException;
    SubGraphPojo aroundVertexUriWithDepthInShareLevels(URI centerVertexUri, Integer depth, Integer... shareLevels) throws NonExistingResourceException;
    SubGraphPojo graphWithDepthResultsLimitAndCenterBubbleUri(Integer depthOfSubVertices, Integer resultsLimit, URI centerBubbleUri) throws NonExistingResourceException;
    SubGraphPojo graphWithAnyVertexAndDepth(Integer depth) throws InvalidDepthOfSubVerticesException;
    VertexOperator vertexWithUri(URI uri);
    EdgeOperator edgeWithUri(URI uri);
    SchemaPojo schemaPojoWithUri(URI uri);
    SchemaOperator schemaOperatorWithUri(URI uri);
    VertexPojo createVertex();
    SchemaPojo createSchema();
}
