/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.graph.exceptions;


import java.net.URI;

public class NonExistingResourceException extends GraphManipulatorException {

    public NonExistingResourceException(URI resourceId){
        super("Resource with URI: " + resourceId + " not found");
    }
}
