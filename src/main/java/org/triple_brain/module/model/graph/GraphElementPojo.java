package org.triple_brain.module.model.graph;

import org.triple_brain.module.model.FriendlyResource;
import org.triple_brain.module.model.Image;
import org.triple_brain.module.model.UserUris;

import java.net.URI;
import java.util.*;

/*
* Copyright Mozilla Public License 1.1
*/
public class GraphElementPojo implements GraphElement {

    private FriendlyResourcePojo friendlyResource;
    private Map<URI,FriendlyResourcePojo> genericIdentifications;
    private Map<URI,FriendlyResourcePojo> sameAs;
    private Map<URI,FriendlyResourcePojo> additionalTypes;

    @Deprecated
    public GraphElementPojo(GraphElementOperator graphElementOperator){
        this(
                new FriendlyResourcePojo(graphElementOperator),
                mapOfFriendlyResourceFromOperator(graphElementOperator.getGenericIdentifications()),
                mapOfFriendlyResourceFromOperator(graphElementOperator.getSameAs()),
                mapOfFriendlyResourceFromOperator(graphElementOperator.getAdditionalTypes())
        );
    }
    public GraphElementPojo(
            FriendlyResourcePojo friendlyResource,
            Map<URI,FriendlyResourcePojo> genericIdentifications
    ){
        this.friendlyResource = friendlyResource;
        this.genericIdentifications = genericIdentifications;
    }

    public GraphElementPojo(
            FriendlyResourcePojo friendlyResource
    ){
        this.friendlyResource = friendlyResource;
    }

    public GraphElementPojo(
            FriendlyResourcePojo friendlyResource,
            Map<URI,FriendlyResourcePojo> genericIdentifications,
            Map<URI,FriendlyResourcePojo> sameAs,
            Map<URI,FriendlyResourcePojo> additionalTypes
    ){
        this.friendlyResource = friendlyResource;
        this.genericIdentifications = genericIdentifications;
        this.sameAs = sameAs;
        this.additionalTypes = additionalTypes;
    }

    @Override
    public boolean hasLabel() {
        return friendlyResource.hasLabel();
    }

    @Override
    public Map<URI, FriendlyResourcePojo> getGenericIdentifications() {
        return genericIdentifications;
    }

    @Override
    public Map<URI, FriendlyResourcePojo> getSameAs() {
        return sameAs;
    }

    @Override
    public Map<URI, FriendlyResourcePojo> getAdditionalTypes() {
        return additionalTypes;
    }

    @Override
    public Map<URI, FriendlyResource> getIdentifications() {
        Map<URI, FriendlyResource> identifications = new HashMap<>();
        identifications.putAll(getSameAs());
        identifications.putAll(getAdditionalTypes());
        identifications.putAll(getGenericIdentifications());
        return identifications;
    }

    @Override
    public String ownerUsername() {
        return UserUris.ownerUserNameFromUri(
                uri()
        );
    }

    @Override
    public URI uri() {
        return friendlyResource.uri();
    }

    @Override
    public String label() {
        return friendlyResource.label();
    }

    @Override
    public Set<Image> images() {
        return friendlyResource.images();
    }

    @Override
    public Boolean gotImages() {
        return friendlyResource.gotImages();
    }

    @Override
    public String comment() {
        return friendlyResource.comment();
    }

    @Override
    public Boolean gotComments() {
        return friendlyResource.gotComments();
    }

    @Override
    public Date creationDate() {
        return friendlyResource.creationDate();
    }

    @Override
    public Date lastModificationDate() {
        return friendlyResource.lastModificationDate();
    }

    @Override
    public boolean equals(Object graphElementToCompareAsObject) {
        return friendlyResource.equals(graphElementToCompareAsObject);
    }

    @Override
    public int hashCode() {
        return friendlyResource.hashCode();
    }

    @Deprecated
    public FriendlyResourcePojo getFriendlyResource(){
        return friendlyResource;
    }

    private static Map<URI, FriendlyResourcePojo> mapOfFriendlyResourceFromOperator(Map<URI, ? extends FriendlyResource> resources){
        Map<URI, FriendlyResourcePojo> friendlyResourcesPojo = new HashMap<>();
        for(FriendlyResource friendlyResource : resources.values()){
            FriendlyResourceOperator friendlyResourceOperator = (FriendlyResourceOperator) friendlyResource;
            friendlyResourcesPojo.put(
                    friendlyResource.uri(),
                    new FriendlyResourcePojo(
                            friendlyResourceOperator
                    )
            );
        }
        return friendlyResourcesPojo;
    }
}
