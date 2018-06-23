/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.graph;

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

    public static Set<ShareLevel> allShareLevels = Stream.of(
            ShareLevel.PRIVATE,
            ShareLevel.FRIENDS,
            ShareLevel.PUBLIC_WITH_LINK,
            ShareLevel.PUBLIC
    ).collect(Collectors.toSet());

    // Reverse-lookup map for getting a share level from it's index
    private static final Map<Integer, ShareLevel> lookup = new HashMap<Integer, ShareLevel>();

    static {
        for (ShareLevel d : ShareLevel.values()) {
            lookup.put(d.getConfidentialityIndex(), d);
        }
    }

    private Integer confidentialityIndex;

    ShareLevel(Integer confidentialityIndex) {
        this.confidentialityIndex = confidentialityIndex;
    }

    public Integer getConfidentialityIndex() {
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
}
