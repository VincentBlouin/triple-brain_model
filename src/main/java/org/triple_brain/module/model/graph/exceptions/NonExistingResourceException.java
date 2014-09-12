/*
 * Copyright Vincent Blouin under the Mozilla Public License 1.1
 */

package org.triple_brain.module.model.graph.exceptions;


import java.net.URI;

public class NonExistingResourceException extends GraphManipulatorException {

    public NonExistingResourceException(URI resourceId){
        super("Resource with URI: " + resourceId + " not found");
    }
}
