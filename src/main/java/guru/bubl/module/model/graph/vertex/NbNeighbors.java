package guru.bubl.module.model.graph.vertex;

import guru.bubl.module.model.graph.ShareLevel;

public interface NbNeighbors {
    Integer getPrivate();

    void setPrivate(Integer private_);

    Integer getFriend();

    void setFriend(Integer friend);

    Integer getPublic();

    void setPublic(Integer public_);

    default Integer getTotalForShareLevel(ShareLevel shareLevel) {
        switch (shareLevel) {
            case PRIVATE:
                return getPrivate() + getFriend() + getPublic();
            case FRIENDS:
                return getFriend() + getPublic();
            default:
                return getPublic();
        }
    }

    default Integer getTotal() {
        /*
        cannot do the if null in the getters because sometimes I want
        to test if the value is null
         */
        Integer nbPrivate = this.getPrivate();
        if (nbPrivate == null) {
            nbPrivate = 0;
        }
        Integer nbFriend = this.getFriend();
        if (nbFriend == null) {
            nbFriend = 0;
        }
        Integer nbPublic = this.getPublic();
        if (nbPublic == null) {
            nbPublic = 0;
        }
        return nbPrivate + nbFriend + nbPublic;
    }
}
