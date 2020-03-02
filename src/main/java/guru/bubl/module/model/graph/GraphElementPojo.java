/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.graph;

import guru.bubl.module.model.Image;
import guru.bubl.module.model.graph.tag.Tag;
import guru.bubl.module.model.graph.tag.TagPojo;

import java.net.URI;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GraphElementPojo implements GraphElement {

    private FriendlyResourcePojo friendlyResource;
    private Map<URI, TagPojo> identifications;
    private Long sortDate;
    private Long moveDate;
    private String childrenIndex;
    private String font;
    URI patternUri;

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
            Map<URI, TagPojo> identifications
    ) {
        this.friendlyResource = friendlyResource;
        this.identifications = identifications;
    }

    public GraphElementPojo(
            FriendlyResourcePojo friendlyResource,
            Map<URI, TagPojo> identifications,
            URI patternUri
    ) {
        this.friendlyResource = friendlyResource;
        this.identifications = identifications;
        this.patternUri = patternUri;
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
    public Map<URI, TagPojo> getIdentifications() {
        return identifications;
    }

    @Override
    public String getColors() {
        return this.friendlyResource.getColors();
    }

    public void setColors(String colors) {
        this.friendlyResource.setColors(colors);
    }

    @Override
    public String getFont() {
        return font == null ? "" : font;
    }

    public void setFont(String font) {
        this.font = font;
    }


    @Override
    public String getChildrenIndex() {
        return childrenIndex == null ? "" : childrenIndex;
    }

    public void setPatternUri(URI patternUri) {
        this.patternUri = patternUri;
    }

    @Override
    public URI getPatternUri() {
        return patternUri;
    }

    public void setChildrenIndex(String childrenIndex) {
        this.childrenIndex = childrenIndex;
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
    public boolean equals(Object graphElementToCompareAsObject) {
        return friendlyResource.equals(graphElementToCompareAsObject);
    }

    @Override
    public int hashCode() {
        return friendlyResource.hashCode();
    }

    public FriendlyResourcePojo getFriendlyResource() {
        return friendlyResource;
    }

    private static Map<URI, TagPojo> convertIdentificationsToPojo(Map<URI, ? extends Tag> identifications) {
        Map<URI, TagPojo> identificationsPojo = new HashMap<>();
        for (Tag identification : identifications.values()) {
            identificationsPojo.put(
                    identification.getExternalResourceUri(),
                    (TagPojo) identification
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
        if (null == sortDate) {
            return null;
        }
        return new Date(
                sortDate
        );
    }

    public Date getMoveDate() {
        if (null == moveDate) {
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

    public Boolean hasUri() {
        return this.friendlyResource.hasUri();
    }
}
