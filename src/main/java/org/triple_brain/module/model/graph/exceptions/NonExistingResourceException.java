package org.triple_brain.module.model.graph.exceptions;


public class NonExistingResourceException extends JenaGraphManipulatorException {

    public NonExistingResourceException(String resourceId){
        super("Resource with URI: " + resourceId + " not found");
    }
}
