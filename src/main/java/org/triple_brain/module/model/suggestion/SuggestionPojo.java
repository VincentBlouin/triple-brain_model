package org.triple_brain.module.model.suggestion;

import org.triple_brain.module.model.FriendlyResource;
import org.triple_brain.module.model.Image;
import org.triple_brain.module.model.User;
import org.triple_brain.module.model.UserUris;
import org.triple_brain.module.model.graph.FriendlyResourcePojo;

import java.net.URI;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/*
* Copyright Mozilla Public License 1.1
*/
public class SuggestionPojo implements Suggestion {

    FriendlyResourcePojo friendlyResource;
    URI sameAsUri;
    URI domainUri;
    Set<SuggestionOriginPojo> origins;

    public static SuggestionPojo fromSameAsAndDomainUriLabelAndOrigin(
            URI sameAsUri,
            URI domainUri,
            String label,
            String origin,
            User owner
    ){
        SuggestionOriginPojo suggestionOriginPojo = new SuggestionOriginPojo(
                origin
        );
        Set<SuggestionOriginPojo> origins = new HashSet<>();
        origins.add(suggestionOriginPojo);
        return new SuggestionPojo(
                sameAsUri,
                domainUri,
                label,
                origins,
                owner
        );
    }

    public SuggestionPojo(
            FriendlyResourcePojo friendlyResource,
            URI sameAsUri,
            URI domainUri,
            Set<SuggestionOriginPojo> origins
    ){
        this.friendlyResource = friendlyResource;
        this.sameAsUri = sameAsUri;
        this.domainUri = domainUri;
        this.origins = origins;
    }
    public SuggestionPojo(
            URI sameAsUri,
            URI domainUri,
            String label,
            Set<SuggestionOriginPojo> origins,
            User owner
    ){
        UserUris userUris = new UserUris(owner);
        URI suggestionUri = URI.create(
                userUris.baseUri() + "/suggestion/" + UUID.randomUUID()
        );
        this.friendlyResource = new FriendlyResourcePojo(
            suggestionUri
        );
        friendlyResource.setLabel(label);
        this.sameAsUri = sameAsUri;
        this.domainUri = domainUri;
        for(SuggestionOriginPojo suggestionOriginPojo: origins){
            suggestionOriginPojo.setUri(
                    URI.create(
                            suggestionUri.toString() + "/origin/" + UUID.randomUUID()
                    )
            );
        }
        this.origins = origins;
   }

    @Override
    public URI getSameAsUri() {
        return sameAsUri;
    }

    @Override
    public URI getDomainUri() {
        return domainUri;
    }

    @Override
    public Set<SuggestionOriginPojo> origins() {
        return origins;
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

}
