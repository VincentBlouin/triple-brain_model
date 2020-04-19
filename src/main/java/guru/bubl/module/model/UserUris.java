/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model;

import guru.bubl.module.model.graph.graph_element.GraphElementType;
import org.apache.commons.lang.StringUtils;

import java.net.URI;
import java.util.UUID;

public class UserUris {

    public static final String BASE_URI = "/service/users/";

    public static final String graphPart = "/graph/";

    public static String graphElementShortId(URI uri) {
        String uriStr = uri.toString();
        return uriStr.substring(uriStr.lastIndexOf("/") + 1);
    }

    public static String ownerUserNameFromUri(URI uri) {
        String uriStr = uri.toString();
        String modifiedUriStr = uriStr.replace("/service/users/", "");
        Integer indexOfSlash = modifiedUriStr.indexOf("/");
        if (indexOfSlash != -1) {
            return modifiedUriStr.substring(
                    0,
                    indexOfSlash
            );
        }
        return modifiedUriStr;

    }

    public static Boolean isUriOfATag(URI uri) {
        return uri.toString().contains("/graph/identification");
    }

    public static Boolean isUriOfAGroupRelation(URI uri) {
        return uri.toString().contains("/graph/gr/");
    }

    public static Boolean isMindRespectUri(URI uri) {
        return uri.toString().startsWith(BASE_URI);
    }

    public static GraphElementType getGraphElementTypeFromUri(URI uri) {
        String uriStr = uri.toString().substring(
                uri.toString().indexOf(graphPart) + graphPart.length()
        );
        String graphElementTypeString = uriStr.substring(0, uriStr.indexOf("/"));
        if (graphElementTypeString.equals("identification")) {
            return GraphElementType.Meta;
        }
        if (graphElementTypeString.equals("gr")) {
            return GraphElementType.GroupRelation;
        }
        return GraphElementType.valueOf(StringUtils.capitalize(graphElementTypeString));
    }

    private String userName;

    public UserUris(User user) {
        this(
                user.username()
        );
    }

    public UserUris(String userName) {
        this.userName = userName;
    }

    public URI baseUri() {
        return URI.create(
                BASE_URI + userName
        );
    }

    public URI graphUri() {
        return URI.create(
                baseUri() + "/graph"
        );
    }

    public URI baseGraphElementUri() {
        return URI.create(
                graphUri() + "/graphElement"
        );
    }

    public URI baseVertexUri() {
        return URI.create(
                graphUri() + "/vertex"
        );
    }

    public URI baseEdgeUri() {
        return URI.create(
                graphUri() + "/edge"
        );
    }

    public URI baseGroupRelationUri() {
        return URI.create(
                graphUri() + "/gr"
        );
    }

    public URI edgeUriFromShortId(String shortId) {
        return URI.create(
                baseEdgeUri() + "/" + shortId
        );
    }

    public URI uriFromTypeAndShortId(GraphElementType type, String shortId) {
        return URI.create(
                baseUriFromType(type) + "/" + shortId
        );
    }

    public URI uriFromTypeStringAndShortId(String typeStr, String shortId) {
        GraphElementType type;
        if (typeStr.equals("identification")) {
            type = GraphElementType.Meta;
        } else if (typeStr.equals("gr")) {
            type = GraphElementType.GroupRelation;
        } else {
            type = GraphElementType.valueOf(typeStr.substring(0, 1).toUpperCase() + typeStr.substring(1));
        }
        return uriFromTypeAndShortId(
                type,
                shortId
        );
    }

    private URI baseUriFromType(GraphElementType type) {
        switch (type) {
            case Vertex:
                return baseVertexUri();
            case Edge:
                return baseEdgeUri();
            case Meta:
                return baseTagUri();
            case GroupRelation:
                return baseGroupRelationUri();
            default:
                return baseUri();
        }
    }

    public URI vertexUriFromShortId(String shortId) {
        return URI.create(
                baseVertexUri() + "/" + shortId
        );
    }

    public URI identificationUriFromShortId(String shortId) {
        return URI.create(
                baseTagUri() + "/" + shortId
        );
    }

    public URI generateVertexUri() {
        return URI.create(
                baseVertexUri() + "/" + UUID.randomUUID().toString()
        );
    }

    public URI generateEdgeUri() {
        return URI.create(
                baseEdgeUri() + "/" + UUID.randomUUID().toString()
        );
    }

    public URI baseTagUri() {
        return URI.create(
                graphUri() + "/identification"
        );
    }

    public URI generateTagUri() {
        return URI.create(
                baseTagUri() + "/" + UUID.randomUUID().toString()
        );
    }

    public URI groupRelationUriFromShortId(String shortId) {
        return URI.create(
                baseGroupRelationUri() + "/" + shortId
        );
    }
}
