/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.graph.tag;

import guru.bubl.module.model.Image;
import guru.bubl.module.model.graph.FriendlyResourcePojo;
import guru.bubl.module.model.graph.GraphElementPojo;

import java.net.URI;
import java.util.Date;
import java.util.Map;
import java.util.Set;

public class TagPojo implements Tag {

    URI relationExternalResourceUri = DEFAULT_IDENTIFIER_RELATION_EXTERNAL_URI;
    URI externalResourceUri;
    GraphElementPojo graphElement;
    Integer nbReferences = 0;

    public TagPojo(
            Integer nbReferences,
            GraphElementPojo meta
    ) {
        this.nbReferences = nbReferences;
        this.graphElement = meta;
    }

    public TagPojo(
            URI externalResourceUri,
            Tag identification
    ) {
        graphElement = new GraphElementPojo(externalResourceUri);
        this.externalResourceUri = identification.getExternalResourceUri();
        graphElement.setLabel(identification.label());
        if (identification.comment() != null) {
            graphElement.getFriendlyResource().setComment(
                    identification.comment()
            );
        }
        if (identification.images() != null) {
            graphElement.getFriendlyResource().setImages(
                    identification.images()
            );
        }
        graphElement.getFriendlyResource().setLastModificationDate(new Date().getTime());
    }

    public TagPojo(
            URI externalResourceUri,
            Integer nbReferences,
            GraphElementPojo graphElementPojo
    ) {
        this.externalResourceUri = externalResourceUri;
        this.nbReferences = nbReferences;
        this.graphElement = graphElementPojo;
    }

    public TagPojo(
            URI externalResourceUri,
            GraphElementPojo graphElementPojo
    ) {
        this.externalResourceUri = externalResourceUri;
        this.graphElement = graphElementPojo;
    }


    public TagPojo(
            URI externalResourceUri,
            FriendlyResourcePojo friendlyResourcePojo
    ) {
        this.externalResourceUri = externalResourceUri;
        this.graphElement = new GraphElementPojo(friendlyResourcePojo);
    }

    public TagPojo(
            URI externalResourceUri
    ) {
        this.externalResourceUri = externalResourceUri;
        this.graphElement = new GraphElementPojo(
                new FriendlyResourcePojo(
                        ""
                )
        );
    }

    public TagPojo(
            GraphElementPojo graphElementPojo
    ) {
        this.graphElement = graphElementPojo;
    }

    @Override
    public URI getRelationExternalResourceUri() {
        return relationExternalResourceUri;
    }

    public void setRelationExternalResourceUri(URI relationExternalResourceUri) {
        this.relationExternalResourceUri = relationExternalResourceUri;
    }

    @Override
    public URI getExternalResourceUri() {
        return externalResourceUri;
    }

    @Override
    public Integer getNbReferences() {
        return nbReferences;
    }

    public TagPojo setNbRefences(Integer nbReferences) {
        this.nbReferences = nbReferences;
        return this;
    }

    public void setExternalResourceUri(URI externalResourceUri) {
        this.externalResourceUri = externalResourceUri;
    }

    @Override
    public URI uri() {
        return graphElement.uri();
    }

    @Override
    public boolean hasLabel() {
        return graphElement.hasLabel();
    }

    @Override
    public String label() {
        return graphElement.label();
    }

    @Override
    public Set<Image> images() {
        return graphElement.images();
    }

    public void setImages(Set<Image> images) {
        graphElement.getFriendlyResource().setImages(images);
    }

    @Override
    public Boolean gotImages() {
        return graphElement.gotImages();
    }

    @Override
    public String comment() {
        return graphElement.comment();
    }

    public void setComment(String comment) {
        graphElement.getFriendlyResource().setComment(comment);
    }

    @Override
    public Boolean gotComments() {
        return graphElement.gotComments();
    }

    @Override
    public Date creationDate() {
        return graphElement.creationDate();
    }

    @Override
    public Date lastModificationDate() {
        return graphElement.lastModificationDate();
    }

    @Override
    public String getColors() {
        return graphElement.getColors();
    }

    @Override
    public boolean equals(Object toCompare) {
        return graphElement.equals(toCompare);
    }

    @Override
    public int hashCode() {
        return graphElement.hashCode();
    }

    public void setUri(URI uri) {
        graphElement.getFriendlyResource().setUri(uri);
    }

    public void setLastModificationDate(Long date) {
        graphElement.getFriendlyResource().setLastModificationDate(
                date
        );
    }

    public GraphElementPojo getGraphElement() {
        return graphElement;
    }

    public void setCreationDate(Long date) {
        graphElement.setCreationDate(date);
    }

    public void setLabel(String label) {
        graphElement.setLabel(label);
    }

    @Override
    public Map<URI, TagPojo> getIdentifications() {
        return graphElement.getIdentifications();
    }

    @Override
    public String getFont() {
        return graphElement.getFont();
    }

    @Override
    public String getChildrenIndex() {
        return graphElement.getChildrenIndex();
    }

    @Override
    public URI getPatternUri() {
        return graphElement.getPatternUri();
    }
}
