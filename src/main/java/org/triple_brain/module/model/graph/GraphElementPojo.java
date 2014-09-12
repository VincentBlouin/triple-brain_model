/*
 * Copyright Vincent Blouin under the Mozilla Public License 1.1
 */

package org.triple_brain.module.model.graph;

import org.triple_brain.module.model.Image;
import org.triple_brain.module.model.UserUris;

import java.net.URI;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GraphElementPojo implements GraphElement {

    private FriendlyResourcePojo friendlyResource;
    private Map<URI,IdentificationPojo> genericIdentifications;
    private Map<URI,IdentificationPojo> sameAs;
    private Map<URI,IdentificationPojo> additionalTypes;

    @Deprecated
    public GraphElementPojo(GraphElementOperator graphElementOperator){
        this(
                new FriendlyResourcePojo(graphElementOperator),
                identificationsFromOperator(graphElementOperator.getGenericIdentifications()),
                identificationsFromOperator(graphElementOperator.getSameAs()),
                identificationsFromOperator(graphElementOperator.getAdditionalTypes())
        );
    }
    public GraphElementPojo(URI uri){
        this(
                new FriendlyResourcePojo(uri)
        );
    }
    public GraphElementPojo(
            FriendlyResourcePojo friendlyResource,
            Map<URI,IdentificationPojo> genericIdentifications
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
            Map<URI,IdentificationPojo> genericIdentifications,
            Map<URI,IdentificationPojo> sameAs,
            Map<URI,IdentificationPojo> additionalTypes
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
    public Map<URI, IdentificationPojo> getGenericIdentifications() {
        return genericIdentifications;
    }

    @Override
    public Map<URI, IdentificationPojo> getSameAs() {
        return sameAs;
    }

    @Override
    public Map<URI, IdentificationPojo> getAdditionalTypes() {
        return additionalTypes;
    }

    @Override
    public Map<URI, IdentificationPojo> getIdentifications() {
        Map<URI, IdentificationPojo> identifications = new HashMap<>();
        identifications.putAll(getSameAs());
        identifications.putAll(getAdditionalTypes());
        identifications.putAll(getGenericIdentifications());
        return identifications;
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
    public String getOwnerUsername() {
        return friendlyResource.getOwnerUsername();
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

    private static Map<URI, IdentificationPojo> identificationsFromOperator(Map<URI, ? extends Identification> resources){
        Map<URI, IdentificationPojo> identificationPojo = new HashMap<>();
        for(Identification identification: resources.values()){
            IdentificationOperator identificationOperator = (IdentificationOperator) identification;
            identificationPojo.put(
                    identificationOperator.getExternalResourceUri(),
                    new IdentificationPojo(
                            identification.uri(),
                            new FriendlyResourcePojo(identificationOperator)
                    )
            );
        }
        return identificationPojo;
    }

    @Override
    public URI getExternalResourceUri() {
        return uri();
    }
}
