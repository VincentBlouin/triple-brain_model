package guru.bubl.module.model.graph.vertex;

import guru.bubl.module.model.graph.ShareLevel;

public interface VertexTypeOperator extends VertexType {

    void setShareLevel(ShareLevel shareLevel);

    void setShareLevel(ShareLevel shareLevel, ShareLevel previousShareLevel);

    default void makePublic() {
        setShareLevel(ShareLevel.PUBLIC);
    }

    default void makePrivate() {
        setShareLevel(ShareLevel.PRIVATE);
    }

}
