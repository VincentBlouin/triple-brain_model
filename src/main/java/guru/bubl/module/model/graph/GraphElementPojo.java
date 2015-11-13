/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.graph;

import guru.bubl.module.model.Image;
import org.joda.time.DateTime;

import java.net.URI;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GraphElementPojo implements GraphElement {

    private FriendlyResourcePojo friendlyResource;
    private Map<URI,IdentificationPojo> identifications;

    @Deprecated
    public GraphElementPojo(GraphElementOperator graphElementOperator){
        this(
                new FriendlyResourcePojo(graphElementOperator),
                convertIdentificationsToPojo(graphElementOperator.getIdentifications())
        );
    }
    public GraphElementPojo(URI uri){
        this(
                new FriendlyResourcePojo(uri)
        );
    }
    public GraphElementPojo(
            FriendlyResourcePojo friendlyResource,
            Map<URI,IdentificationPojo> identifications
    ){
        this.friendlyResource = friendlyResource;
        this.identifications = identifications;
    }

    public GraphElementPojo(
            FriendlyResourcePojo friendlyResource
    ){
        this.friendlyResource = friendlyResource;
    }

    @Override
    public boolean hasLabel() {
        return friendlyResource.hasLabel();
    }

    @Override
    public Map<URI, IdentificationPojo> getGenericIdentifications() {
        return getIdentificationsOfType(
                IdentificationType.generic
        );
    }

    @Override
    public Map<URI, IdentificationPojo> getSameAs() {
        return getIdentificationsOfType(
                IdentificationType.same_as
        );
    }

    @Override
    public Map<URI, IdentificationPojo> getAdditionalTypes() {
        return getIdentificationsOfType(
                IdentificationType.type
        );
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
    public FriendlyResourcePojo getFriendlyResource(){
        return friendlyResource;
    }

    private Map<URI, IdentificationPojo> getIdentificationsOfType(IdentificationType identificationType){
        Map<URI, IdentificationPojo> identificationsOfType = new HashMap<>();
        for(IdentificationPojo identification : getIdentifications().values()){
            if(identification.getType().equals(identificationType)){
                identificationsOfType.put(
                        identification.getExternalResourceUri(),
                        identification
                );
            }
        }
        return identificationsOfType;
    }

    private static Map<URI, IdentificationPojo> convertIdentificationsToPojo(Map<URI, ? extends Identification> identifications){
        Map<URI, IdentificationPojo> identificationsPojo = new HashMap<>();
        for (Identification identification : identifications.values()) {
            identificationsPojo.put(
                    identification.getExternalResourceUri(),
                    (IdentificationPojo) identification
            );
        }
        return identificationsPojo;
    }


    public void removeAllIdentifications(){
        identifications.clear();
    }

    public void setLabel(String label){
        friendlyResource.setLabel(label);
    }

    public void setCreationDate(DateTime creationDate){
        friendlyResource.setCreationDate(creationDate.toDate());
    }
}
