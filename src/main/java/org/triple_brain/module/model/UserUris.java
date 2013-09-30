package org.triple_brain.module.model;

import java.net.URI;
import java.util.UUID;

/*
* Copyright Mozilla Public License 1.1
*/
public class UserUris {
    private String userName;

    public UserUris(User user){
        this(
                user.username()
        );
    }
    public UserUris(String userName){
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

    public URI defaultVertexUri() {
        return URI.create(
                baseVertexUri() + "/" + TripleBrainUris.DEFAULT_VERTEX_END_OF_URI
        );
    }

    public URI edgeUriFromShortId(String shortId){
        return URI.create(
                baseEdgeUri() + "/" + shortId
        );
    }

    public URI vertexUriFromShortId(String shortId){
        return URI.create(
            baseVertexUri() + "/" + shortId
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

    public static String graphElementShortId (URI uri){
        String uriStr = uri.toString();
        return uriStr.substring(uriStr.lastIndexOf("/") + 1);
    }

    public static String ownerUserNameFromUri(URI uri){
        String uriStr = uri.toString();
        String modifiedUriStr = uriStr.replace("/service/users/", "");
        return modifiedUriStr.substring(
                0,
                modifiedUriStr.indexOf("/")
        );
    }
}
