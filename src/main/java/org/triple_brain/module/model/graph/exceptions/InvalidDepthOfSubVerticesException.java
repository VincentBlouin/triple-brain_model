/*
 * Copyright Vincent Blouin under the Mozilla Public License 1.1
 */

package org.triple_brain.module.model.graph.exceptions;

import java.net.URI;

public class InvalidDepthOfSubVerticesException extends GraphManipulatorException {

    public InvalidDepthOfSubVerticesException(Integer depthOfSubvertices, URI centerVertexId){
        super("Invalid depth of sub vertices. Depth was:" + depthOfSubvertices + " and center vertex uri was:" + centerVertexId);
    }
}
