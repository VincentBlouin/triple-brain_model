package org.triple_brain.module.model.suggestion;

import org.triple_brain.module.model.FriendlyResource;
import org.triple_brain.module.model.Image;
import org.triple_brain.module.model.graph.FriendlyResourcePojo;

import java.net.URI;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/*
* Copyright Mozilla Public License 1.1
*/
public class SuggestionPojo implements Suggestion {

    FriendlyResourcePojo friendlyResource;
    FriendlyResourcePojo sameAs;
    FriendlyResourcePojo domain;
    Set<SuggestionOriginPojo> origins;

    public static SuggestionPojo fromSameAsAndDomainUriLabelAndOrigin(
            String sameAsUri,
            String domainUri,
            String label,
            String origin
    ){
        FriendlyResourcePojo sameAs = new FriendlyResourcePojo(
                URI.create(sameAsUri),
                label,
                new HashSet<Image>(),
                "",
                new Date(),
                new Date()
        );
        FriendlyResourcePojo domain = new FriendlyResourcePojo(
                URI.create(domainUri)
        );
        SuggestionOriginPojo suggestionOriginPojo = new SuggestionOriginPojo(
                origin
        );
        Set<SuggestionOriginPojo> origins = new HashSet<>();
        origins.add(suggestionOriginPojo);
        return new SuggestionPojo(
                sameAs,
                domain,
                origins
        );
    }

    public SuggestionPojo(
            FriendlyResourcePojo friendlyResource,
            FriendlyResourcePojo sameAs,
            FriendlyResourcePojo domain,
            Set<SuggestionOriginPojo> origins
    ){
        this.friendlyResource = friendlyResource;
        this.sameAs = sameAs;
        this.domain = domain;
        this.origins = origins;
    }
    public SuggestionPojo(
            FriendlyResourcePojo sameAs,
            FriendlyResourcePojo domain,
            Set<SuggestionOriginPojo> origins
    ){
        this(
                null,
                sameAs,
                domain,
                origins
        );
   }
    public SuggestionPojo(
            SuggestionOperator suggestionOperator
    ){
        this(
                new FriendlyResourcePojo(suggestionOperator),
                new FriendlyResourcePojo(suggestionOperator.sameAs()),
                new FriendlyResourcePojo((suggestionOperator.domain())),
                convertSuggestionOriginOperatorSetToPojo(suggestionOperator.origins())
        );
    }

    @Override
    public FriendlyResource sameAs() {
        return sameAs;
    }

    @Override
    public FriendlyResource domain() {
        return domain;
    }

    @Override
    public Set<SuggestionOrigin> origins() {
        Set<SuggestionOrigin> origins = new HashSet<>();
        origins.addAll(this.origins);
        return origins;
    }

    @Override
    public URI uri() {
        return friendlyResource.uri();
    }

    @Override
    public boolean hasLabel() {
        return sameAs.hasLabel();
    }

    @Override
    public String label() {
        return sameAs.label();
    }

    @Override
    public Set<Image> images() {
        return sameAs.images();
    }

    @Override
    public Boolean gotImages() {
        return sameAs.gotImages();
    }

    @Override
    public String comment() {
        return sameAs.comment();
    }

    @Override
    public Boolean gotComments() {
        return sameAs.gotComments();
    }

    @Override
    public Date creationDate() {
        return friendlyResource.creationDate();
    }

    @Override
    public Date lastModificationDate() {
        return friendlyResource.lastModificationDate();
    }

    public static Set<SuggestionOriginPojo> convertSuggestionOriginOperatorSetToPojo(Set<SuggestionOrigin> suggestionOrigins){
        Set<SuggestionOriginPojo> suggestionOriginsPojo = new HashSet<>();
        for(SuggestionOrigin suggestionOrigin : suggestionOrigins){
            suggestionOriginsPojo.add(
                    new SuggestionOriginPojo(
                            (SuggestionOriginOperator) suggestionOrigin
                    )
            );
        }
        return suggestionOriginsPojo;
    }
}
