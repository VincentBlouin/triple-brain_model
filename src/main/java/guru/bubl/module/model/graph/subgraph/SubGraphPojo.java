/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.graph.subgraph;

import guru.bubl.module.model.graph.graph_element.GraphElement;
import guru.bubl.module.model.graph.relation.Relation;
import guru.bubl.module.model.graph.relation.RelationPojo;
import guru.bubl.module.model.graph.group_relation.GroupRelationPojo;
import guru.bubl.module.model.graph.tag.TagPojo;
import guru.bubl.module.model.graph.vertex.Vertex;
import guru.bubl.module.model.graph.vertex.VertexPojo;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class SubGraphPojo implements SubGraph {

    private Map<URI, VertexPojo> vertices = new HashMap<>();
    private Map<URI, RelationPojo> edges = new HashMap<>();
    Map<URI, GroupRelationPojo> groupRelations = new HashMap<>();
    private TagPojo centerTag;

    public static SubGraphPojo withCenterUriVerticesAndEdges(Map<URI, VertexPojo> vertices, Map<URI, RelationPojo> edges) {
        return new SubGraphPojo(vertices, edges);
    }

    protected SubGraphPojo(Map<URI, VertexPojo> vertices, Map<URI, RelationPojo> edges) {
        this.vertices = vertices;
        this.edges = edges;
    }

    @Override
    public VertexPojo vertexWithIdentifier(URI identifier) {
        return vertices.get(
                identifier
        );
    }

    @Override
    public RelationPojo edgeWithIdentifier(URI identifier) {
        return edges.get(
                identifier
        );
    }

    @Override
    public int numberOfEdgesAndVertices() {
        return numberOfEdges() +
                numberOfVertices();
    }

    @Override
    public int numberOfEdges() {
        return edges.size();
    }

    @Override
    public int numberOfVertices() {
        return vertices.size();
    }

    @Override
    public Boolean containsVertex(Vertex vertex) {
        return vertices.containsKey(
                vertex.uri()
        );
    }

    @Override
    public Boolean containsEdge(Relation relation) {
        return edges.containsKey(relation.uri());
    }

    @Override
    public Boolean hasEdgeWithUri(URI uri) {
        return edges.containsKey(uri);
    }

    @Override
    public Map<URI, VertexPojo> vertices() {
        return vertices;
    }

    public Boolean containsGraphElement(GraphElement graphElement) {
        return edges.containsKey(graphElement.uri()) ||
                vertices.containsKey(graphElement.uri()) ||
                groupRelations.containsKey(graphElement.uri());
    }

    @Override
    public Map<URI, RelationPojo> edges() {
        return edges;
    }

    @Override
    public TagPojo getCenterMeta() {
        return centerTag;
    }

    public Boolean hasCenter(URI uri) {
        return this.getCenterMeta() != null || this.vertexWithIdentifier(uri) != null || this.groupRelations.containsKey(uri);
    }

    public void setCenterMeta(TagPojo tag) {
        this.centerTag = tag;
    }

    public void addEdge(RelationPojo edge) {
        edges.put(
                edge.uri(),
                edge
        );
    }

    public void addVertex(VertexPojo vertex) {
        vertices.put(
                vertex.uri(),
                vertex
        );
    }

    public void addGroupRelation(GroupRelationPojo groupRelation) {
        groupRelations.put(
                groupRelation.uri(),
                groupRelation
        );
    }

    public Boolean isEmpty() {
        return this.vertices().isEmpty();
    }

    public Map<URI, GroupRelationPojo> getGroupRelations() {
        return groupRelations;
    }
}
