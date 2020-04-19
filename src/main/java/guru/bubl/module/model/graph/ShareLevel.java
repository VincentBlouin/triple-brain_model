/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum ShareLevel {
    PRIVATE(10),
    FRIENDS(20),
    PUBLIC_WITH_LINK(30),
    PUBLIC(40);

    public final static Set<ShareLevel> allShareLevels = Stream.of(
            ShareLevel.PRIVATE,
            ShareLevel.FRIENDS,
            ShareLevel.PUBLIC_WITH_LINK,
            ShareLevel.PUBLIC
    ).collect(Collectors.toSet());


    public final static Set<ShareLevel> friendShareLevels = Stream.of(
            ShareLevel.FRIENDS,
            ShareLevel.PUBLIC_WITH_LINK,
            ShareLevel.PUBLIC
    ).collect(Collectors.toSet());

    public final static Set<ShareLevel> publicShareLevels = Stream.of(
            ShareLevel.PUBLIC_WITH_LINK,
            ShareLevel.PUBLIC
    ).collect(Collectors.toSet());

    public final static Integer[] allShareLevelsInt = {
            ShareLevel.PRIVATE.getIndex(),
            ShareLevel.FRIENDS.getIndex(),
            ShareLevel.PUBLIC_WITH_LINK.getIndex(),
            ShareLevel.PUBLIC.getIndex()
    };

    public static Integer[] shareLevelsToIntegers(Set<ShareLevel> shareLevels) {
        return shareLevels.stream().map(ShareLevel::getIndex).toArray(Integer[]::new);
    }

    public static Set<ShareLevel> arrayOfIntegersToSet(Integer[] shareLevels) {
        return Arrays.stream(shareLevels).map(i -> get(i)).collect(Collectors.toSet());
    }

    public static Set<ShareLevel> shareLevelsToSet(ShareLevel... shareLevels) {
        return Stream.of(
                shareLevels
        ).collect(Collectors.toSet());
    }

    // Reverse-lookup map for getting a share level from it's index
    private static final Map<Integer, ShareLevel> lookup = new HashMap<Integer, ShareLevel>();

    static {
        for (ShareLevel d : ShareLevel.values()) {
            lookup.put(d.getIndex(), d);
        }
    }

    private Integer confidentialityIndex;

    ShareLevel(Integer confidentialityIndex) {
        this.confidentialityIndex = confidentialityIndex;
    }

    public Integer getIndex() {
        return confidentialityIndex;
    }

    public static ShareLevel get(Integer confidentialityIndex) {
        return lookup.get(confidentialityIndex);
    }

    public Boolean isPublic() {
        return this == ShareLevel.PUBLIC || this == ShareLevel.PUBLIC_WITH_LINK;
    }

    public Boolean isSame(ShareLevel shareLevel) {
        if (this.isPublic() && shareLevel.isPublic()) {
            return true;
        }
        return this == shareLevel;
    }

    public String getNbNeighborsPropertyName() {
        switch (this) {
            case PRIVATE:
                return "nb_private_neighbors";
            case FRIENDS:
                return "nb_friend_neighbors";
            default:
                return "nb_public_neighbors";
        }
    }
}
