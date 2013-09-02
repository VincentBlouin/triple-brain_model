package org.triple_brain.module.model.json.graph;

import org.codehaus.jettison.json.JSONArray;
import org.triple_brain.module.model.FriendlyResource;
import org.triple_brain.module.model.graph.GraphElement;
import org.triple_brain.module.model.json.ExternalResourceJson;

/*
* Copyright Mozilla Public License 1.1
*/
public class GraphElementJsonFields {
    public static final String TYPES = "types";
    public static final String SAME_AS = "same_as";
    public static final String URI = "uri";

    protected static JSONArray jsonAdditionalTypes(GraphElement graphElement) {
        JSONArray additionalTypes = new JSONArray();
        for (FriendlyResource friendlyResource : graphElement.getAdditionalTypes()) {
            additionalTypes.put(
                    ExternalResourceJson.get(
                            friendlyResource
                    )
            );
        }
        return additionalTypes;
    }

    protected static JSONArray jsonSameAs(GraphElement graphElement) {
        JSONArray sameAs = new JSONArray();
        for (FriendlyResource friendlyResourceImpl : graphElement.getSameAs()) {
            sameAs.put(
                    ExternalResourceJson.get(
                            friendlyResourceImpl
                    )
            );
        }
        return sameAs;
    }
}
