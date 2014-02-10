package org.triple_brain.module.model.graph;

import org.triple_brain.module.model.FriendlyResource;
import org.triple_brain.module.model.Image;
import org.triple_brain.module.model.UserUris;

import java.net.URI;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/*
* Copyright Mozilla Public License 1.1
*/
public class GraphElementPojo implements GraphElement {

    private FriendlyResourcePojo friendlyResource;
    private Set<FriendlyResourcePojo> genericIdentifications;
    private Set<FriendlyResourcePojo> sameAs;
    private Set<FriendlyResourcePojo> additionalTypes;

    @Deprecated
    public GraphElementPojo(GraphElementOperator graphElementOperator){
        this(
                new FriendlyResourcePojo(graphElementOperator),
                setOfFriendlyResourceFromOperator(graphElementOperator.getGenericIdentifications()),
                setOfFriendlyResourceFromOperator(graphElementOperator.getSameAs()),
                setOfFriendlyResourceFromOperator(graphElementOperator.getAdditionalTypes())
        );
    }
    public GraphElementPojo(
            FriendlyResourcePojo friendlyResource,
            Set<FriendlyResourcePojo> genericIdentifications
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
            Set<FriendlyResourcePojo> genericIdentifications,
            Set<FriendlyResourcePojo> sameAs,
            Set<FriendlyResourcePojo> additionalTypes
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
    public Set<FriendlyResource> getGenericIdentifications() {
        return convertSetToInterface(
                genericIdentifications
        );
    }

    @Override
    public Set<FriendlyResource> getSameAs() {
        return convertSetToInterface(
                sameAs
        );
    }

    @Override
    public Set<FriendlyResource> getAdditionalTypes() {
        return convertSetToInterface(
                additionalTypes
        );
    }

    @Override
    public Set<FriendlyResource> getIdentifications() {
        Set<FriendlyResource> identifications = new HashSet<>();
        identifications.addAll(getSameAs());
        identifications.addAll(getAdditionalTypes());
        identifications.addAll(getGenericIdentifications());
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

    private static Set<FriendlyResourcePojo> setOfFriendlyResourceFromOperator(Set<FriendlyResource> friendlyResourcesOperator){
        Set<FriendlyResourcePojo> friendlyResourcesPojo = new HashSet<>();
        for(FriendlyResource friendlyResource : friendlyResourcesOperator){
            FriendlyResourceOperator friendlyResourceOperator = (FriendlyResourceOperator) friendlyResource;
            friendlyResourcesPojo.add(
                    new FriendlyResourcePojo(
                            friendlyResourceOperator
                    )
            );
        }
        return friendlyResourcesPojo;
    }

    private Set<FriendlyResource> convertSetToInterface(Set<FriendlyResourcePojo> friendlyResourcePojoSet){
        Set<FriendlyResource> friendlyResources = new HashSet<>();
        friendlyResources.addAll(friendlyResourcePojoSet);
        return friendlyResources;
    }
}
