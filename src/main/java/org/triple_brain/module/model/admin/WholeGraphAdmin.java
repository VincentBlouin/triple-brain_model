/*
 * Copyright Vincent Blouin under the Mozilla Public License 1.1
 */

package org.triple_brain.module.model.admin;

import org.triple_brain.module.model.FriendlyResource;
import org.triple_brain.module.model.Image;
import org.triple_brain.module.model.WholeGraph;
import org.triple_brain.module.model.graph.vertex.VertexInSubGraphOperator;
import org.triple_brain.module.model.graph.vertex.VertexOperator;

import java.util.Iterator;
import java.util.Set;

public class WholeGraphAdmin {
    private WholeGraph wholeGraph;
    public WholeGraphAdmin(WholeGraph wholeGraph){
        this.wholeGraph = wholeGraph;
    }
    public void refreshNumberOfConnectedEdges(){
        Iterator<VertexInSubGraphOperator> vertexIt = wholeGraph.getAllVertices();
        while(vertexIt.hasNext()){
            VertexOperator vertex = vertexIt.next();
            vertex.setNumberOfConnectedEdges(
                    vertex.connectedEdges().size()
            );
        }
    }



//    public void convertAllSmallImagesToBase64(){
//        Iterator<VertexInSubGraphOperator> vertexIt = wholeGraph.getAllVertices();
//        while(vertexIt.hasNext()){
//            VertexOperator vertex = vertexIt.next();
//            convertImagesSmallVersionToBase64(vertex.images());
//            for(FriendlyResource friendlyResource : vertex.getIdentifications().values()){
//                convertImagesSmallVersionToBase64(friendlyResource.images());
//            }
//        }
//    }
//
//    private void convertImagesSmallVersionToBase64(Set<Image> images){
//        for(Image image : images){
//            image.
//        }
//    }
}
