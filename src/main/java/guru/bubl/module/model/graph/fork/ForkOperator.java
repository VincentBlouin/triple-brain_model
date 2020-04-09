package guru.bubl.module.model.graph.fork;

import guru.bubl.module.model.graph.ShareLevel;
import guru.bubl.module.model.graph.edge.EdgePojo;

public interface ForkOperator extends Fork {

    void setShareLevel(ShareLevel shareLevel);

    void setShareLevel(ShareLevel shareLevel, ShareLevel previousShareLevel);

    default void makePublic() {
        setShareLevel(ShareLevel.PUBLIC);
    }

    default void makePrivate() {
        setShareLevel(ShareLevel.PRIVATE);
    }

    EdgePojo addVertexAndRelation();

    EdgePojo addVertexAndRelationWithIds(String vertexId, String edgeId);

}
