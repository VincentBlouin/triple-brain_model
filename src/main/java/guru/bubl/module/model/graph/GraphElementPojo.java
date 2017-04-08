/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.graph;

import guru.bubl.module.model.Image;
import guru.bubl.module.model.graph.identification.Identification;
import guru.bubl.module.model.graph.identification.IdentificationPojo;

import java.net.URI;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GraphElementPojo implements GraphElement {

    private FriendlyResourcePojo friendlyResource;
    private Map<URI, IdentificationPojo> identifications;
    private Long sortDate;
    private Long moveDate;

    @Deprecated
    public GraphElementPojo(GraphElementOperator graphElementOperator) {
        this(
                new FriendlyResourcePojo(graphElementOperator),
                convertIdentificationsToPojo(graphElementOperator.getIdentifications())
        );
    }

    public GraphElementPojo(URI uri) {
        this(
                new FriendlyResourcePojo(uri)
        );
    }

    public GraphElementPojo(
            FriendlyResourcePojo friendlyResource,
            Map<URI, IdentificationPojo> identifications
    ) {
        this.friendlyResource = friendlyResource;
        this.identifications = identifications;
    }

    public GraphElementPojo(
            FriendlyResourcePojo friendlyResource
    ) {
        this.friendlyResource = friendlyResource;
    }

    @Override
    public boolean hasLabel() {
        return friendlyResource.hasLabel();
    }

    @Override
    public Map<URI, IdentificationPojo> getIdentifications() {
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

    public void addImage(Image image) {
        friendlyResource.addImage(image);
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
    public FriendlyResourcePojo getFriendlyResource() {
        return friendlyResource;
    }

    private static Map<URI, IdentificationPojo> convertIdentificationsToPojo(Map<URI, ? extends Identification> identifications) {
        Map<URI, IdentificationPojo> identificationsPojo = new HashMap<>();
        for (Identification identification : identifications.values()) {
            identificationsPojo.put(
                    identification.getExternalResourceUri(),
                    (IdentificationPojo) identification
            );
        }
        return identificationsPojo;
    }


    public void removeAllIdentifications() {
        identifications.clear();
    }

    public void setLabel(String label) {
        friendlyResource.setLabel(label);
    }

    public void setCreationDate(Long creationDate) {
        friendlyResource.setCreationDate(creationDate);
    }

    public Date getSortDate() {
        if(null == sortDate){
            return null;
        }
        return new Date(
                sortDate
        );
    }

    public Date getMoveDate() {
        if(null == moveDate){
            return null;
        }
        return new Date(
                moveDate
        );
    }

    public GraphElementPojo setSortDate(Long sortDate) {
        this.sortDate = sortDate;
        return this;
    }

    public GraphElementPojo setMoveDate(Long moveDate) {
        this.moveDate = moveDate;
        return this;
    }
}
