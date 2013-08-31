package org.triple_brain.module.model.graph.exceptions;

import java.net.URI;

/**
 * Copyright Mozilla Public License 1.1
 */
public class InvalidDepthOfSubVerticesException extends JenaGraphManipulatorException {

    public InvalidDepthOfSubVerticesException(Integer depthOfSubvertices, URI centerVertexId){
        super("Invalid depth of sub vertices. Depth was:" + depthOfSubvertices + " and center vertex uri was:" + centerVertexId);
    }
}
