/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.friend;

public class FriendPojo {
    private String username;
    private FriendStatus status;

    public FriendPojo(String username, FriendStatus status) {
        this.username = username;
        this.status = status;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public FriendStatus getStatus() {
        return status;
    }

    public void setStatus(FriendStatus status) {
        this.status = status;
    }
}
