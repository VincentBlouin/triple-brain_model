package guru.bubl.module.model.graph.vertex;

public class NbNeighborsPojo implements NbNeighbors {
    private Integer private_;
    private Integer friend;
    private Integer public_;

    public NbNeighborsPojo() {
    }

    public NbNeighborsPojo(Integer private_, Integer friend, Integer public_) {
        this.private_ = private_;
        this.friend = friend;
        this.public_ = public_;
    }

    @Override
    public Integer getPrivate() {
        return private_;
    }

    @Override
    public void setPrivate(Integer private_) {
        this.private_ = private_;
    }

    @Override
    public Integer getFriend() {
        return friend;
    }

    @Override
    public void setFriend(Integer friend) {
        this.friend = friend;
    }

    @Override
    public Integer getPublic() {
        return public_;
    }

    @Override
    public void setPublic(Integer public_) {
        this.public_ = public_;
    }
}
