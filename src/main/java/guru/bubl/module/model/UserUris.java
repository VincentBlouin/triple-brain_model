/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model;

import guru.bubl.module.model.graph.schema.Schema;

import java.net.URI;
import java.util.UUID;

public class UserUris {

    public static String graphElementShortId(URI uri) {
        String uriStr = uri.toString();
        return uriStr.substring(uriStr.lastIndexOf("/") + 1);
    }

    public static String ownerUserNameFromUri(URI uri) {
        String uriStr = uri.toString();
        String modifiedUriStr = uriStr.replace("/service/users/", "");
        Integer indexOfSlash = modifiedUriStr.indexOf("/");
        return indexOfSlash == -1 ?
                modifiedUriStr.substring(
                        0
                ) :
                modifiedUriStr.substring(
                        0,
                        indexOfSlash
                );
    }

    public static URI generateSchemaPropertyUri(URI schemaUri) {
        return URI.create(
                schemaUri + "/property/" + UUID.randomUUID().toString()
        );
    }

    public static URI schemaPropertyUriFromShortIdAndSchema(Schema schema, String shortId) {
        return URI.create(
                schema.uri() + "/property/" + shortId
        );
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
                "/service/users/" + userName
        );
    }

    public URI graphUri() {
        return URI.create(
                baseUri() + "/graph"
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

    public URI baseSchemaUri() {
        return URI.create(
                graphUri() + "/schema"
        );
    }

    public URI edgeUriFromShortId(String shortId) {
        return URI.create(
                baseEdgeUri() + "/" + shortId
        );
    }

    public URI vertexUriFromShortId(String shortId) {
        return URI.create(
                baseVertexUri() + "/" + shortId
        );
    }

    public URI schemaUriFromShortId(String shortId) {
        return URI.create(
                baseSchemaUri() + "/" + shortId
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

    public URI generateSchemaUri() {
        return URI.create(
                baseSchemaUri() + "/" + UUID.randomUUID().toString()
        );
    }

    public URI baseIdentificationUri() {
        return URI.create(
                graphUri() + "/identification"
        );
    }

    public URI generateIdentificationUri() {
        return URI.create(
                baseIdentificationUri() + "/" + UUID.randomUUID().toString()
        );
    }

    public URI generateSuggestionUri() {
        return URI.create(
                baseUri() + "/suggestion/" + UUID.randomUUID()
        );
    }
}
