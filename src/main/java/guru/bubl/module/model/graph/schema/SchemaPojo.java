/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.graph.schema;

import guru.bubl.module.model.graph.*;
import guru.bubl.module.model.Image;
import guru.bubl.module.model.graph.identification.IdentifierPojo;

import java.net.URI;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SchemaPojo implements Schema {

    private GraphElementPojo graphElement;
    private Map<URI, GraphElementPojo> properties;

    @Deprecated
    public SchemaPojo(SchemaOperator schemaOperator) {
        this.graphElement = new GraphElementPojo(schemaOperator);
        properties = new HashMap<>();
        for(GraphElement property : schemaOperator.getProperties().values()){
            properties.put(
                    property.uri(),
                    new GraphElementPojo((GraphElementOperator) property)
            );
        }
    }

    public SchemaPojo(URI uri) {
        this(
                new GraphElementPojo(uri)
        );
    }

    public SchemaPojo(GraphElementPojo graphElementPojo) {
        this.graphElement = graphElementPojo;
    }

    public SchemaPojo(
            GraphElementPojo graphElementPojo,
            Map<URI, GraphElementPojo> properties
    ) {
        this.graphElement = graphElementPojo;
        this.properties = properties;
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

    @Override
    public Boolean gotImages() {
        return graphElement.gotImages();
    }

    @Override
    public String comment() {
        return graphElement.comment();
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

    public void setLabel(String label) {
        graphElement.setLabel(label);
    }

    @Override
    public Map<URI, GraphElementPojo> getProperties() {
        return properties;
    }

    public Boolean hasProperties(){
        return properties != null;
    }

    @Override
    public boolean equals(Object graphElementToCompareAsObject) {
        return graphElement.equals(graphElementToCompareAsObject);
    }

    @Override
    public int hashCode() {
        return graphElement.hashCode();
    }

    @Override
    public Map<URI, IdentifierPojo> getIdentifications() {
        return graphElement.getIdentifications();
    }

}
