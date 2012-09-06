package org.triple_brain.module.model.graph.exceptions;

/**
 * Copyright Mozilla Public License 1.1
 */
public class InvalidDepthOfSubVerticesException extends JenaGraphManipulatorException {

    public InvalidDepthOfSubVerticesException(Integer depthOfSubvertices, String centerVertexId){
        super("Invalid depth of sub vertices. Depth was:" + depthOfSubvertices + " and center vertex id was:" + centerVertexId);
    }
}
