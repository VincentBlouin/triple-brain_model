/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.suggestion;

import guru.bubl.module.model.Image;
import guru.bubl.module.model.User;
import guru.bubl.module.model.UserUris;
import guru.bubl.module.model.graph.FriendlyResourcePojo;

import java.net.URI;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class SuggestionPojo implements Suggestion {
    FriendlyResourcePojo friendlyResource;
    FriendlyResourcePojo sameAs;
    FriendlyResourcePojo type;
    Set<SuggestionOriginPojo> origins;

    public static SuggestionPojo forSameAsTypeAndOrigin(
            FriendlyResourcePojo sameAs,
            FriendlyResourcePojo type,
            String origin,
            User owner
    ) {
        SuggestionOriginPojo suggestionOriginPojo = new SuggestionOriginPojo(
                origin
        );
        Set<SuggestionOriginPojo> origins = new HashSet<>();
        origins.add(suggestionOriginPojo);
        return new SuggestionPojo(
                sameAs,
                type,
                sameAs.label(),
                origins,
                owner
        );
    }

    public SuggestionPojo(
            FriendlyResourcePojo friendlyResource,
            FriendlyResourcePojo sameAs,
            FriendlyResourcePojo type,
            Set<SuggestionOriginPojo> origins
    ) {
        this.friendlyResource = friendlyResource;
        this.sameAs = sameAs;
        this.type = type;
        this.origins = origins;
    }

    public SuggestionPojo(
            FriendlyResourcePojo sameAs,
            FriendlyResourcePojo type,
            String label,
            Set<SuggestionOriginPojo> origins,
            User owner
    ) {
        UserUris userUris = new UserUris(owner);
        URI suggestionUri = userUris.generateSuggestionUri();

        this.friendlyResource = new FriendlyResourcePojo(
                suggestionUri
        );
        friendlyResource.setLabel(label);
        this.sameAs = sameAs;
        this.type = type;
        for (SuggestionOriginPojo suggestionOriginPojo : origins) {
            suggestionOriginPojo.setUri(
                    URI.create(
                            suggestionUri.toString() + "/origin/" + UUID.randomUUID()
                    )
            );
        }
        this.origins = origins;
    }

    @Override
    public FriendlyResourcePojo getSameAs() {
        return sameAs;
    }

    @Override
    public FriendlyResourcePojo getType() {
        return type;
    }

    @Override
    public Set<SuggestionOriginPojo> origins() {
        return origins;
    }

    @Override
    public URI uri() {
        return friendlyResource.uri();
    }

    public void setUri(URI uri) {
        if (friendlyResource == null) {
            friendlyResource = new FriendlyResourcePojo(
                    uri
            );
        } else {
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
    public String getOwnerUsername() {
        return friendlyResource.getOwnerUsername();
    }
}
