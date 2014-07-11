package org.triple_brain.module.model.suggestion;

import org.triple_brain.module.model.FriendlyResource;
import org.triple_brain.module.model.Image;
import org.triple_brain.module.model.graph.FriendlyResourcePojo;

import java.net.URI;
import java.util.Date;
import java.util.Set;

/*
* Copyright Mozilla Public License 1.1
*/
public class SuggestionOriginPojo implements SuggestionOrigin{

    FriendlyResourcePojo friendlyResource;
    String origin;

    public SuggestionOriginPojo(
            String origin
    ){
        this.origin = origin;
    }
    public SuggestionOriginPojo(
            FriendlyResourcePojo friendlyResource,
            String origin
    ){
        this.friendlyResource = friendlyResource;
        this.origin = origin;
    }

    public SuggestionOriginPojo(
            SuggestionOriginOperator suggestionOriginOperator
    ){
        this(
                new FriendlyResourcePojo(suggestionOriginOperator),
                suggestionOriginOperator.toString()
        );
    }

    @Override
    public URI uri() {
        return friendlyResource.uri();
    }

    public void setUri(URI uri){
        if(friendlyResource == null){
            friendlyResource = new FriendlyResourcePojo(
                    uri
            );
        }else{
            friendlyResource.setUri(
                    uri
            );
        }
    }

    @Override
    public boolean hasLabel() {
        return friendlyResource.hasLabel();
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
    public String getOwner() {
        return friendlyResource.getOwner();
    }

    @Override
    public Boolean isRelatedToFriendlyResource(FriendlyResource friendlyResource) {
        return origin.contains(
                friendlyResource.uri().toString()
        );
    }

    @Override
    public String toString(){
        return origin;
    }
}
