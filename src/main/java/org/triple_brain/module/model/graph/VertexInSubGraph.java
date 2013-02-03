package org.triple_brain.module.model.graph;

/*
* Copyright Mozilla Public License 1.1
*/
public interface VertexInSubGraph extends Vertex{
    public Integer minDistanceFromCenterVertex();
    public VertexInSubGraph setMinDistanceFromCenterVertex(Integer minDistanceFromCenterVertex);
}
