package org.triple_brain.module.model.json.graph;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.triple_brain.module.model.FriendlyResource;
import org.triple_brain.module.model.graph.GraphElement;
import org.triple_brain.module.model.json.FriendlyResourceJson;

/*
* Copyright Mozilla Public License 1.1
*/
public class GraphElementJson extends FriendlyResourceJson {

    public static final String TYPES = "types";
    public static final String SAME_AS = "same_as";
    public static final String GENERIC_IDENTIFICATIONS = "generic_identifications";

    protected static JSONObject toJson(GraphElement graphElement){
        try{
            return FriendlyResourceJson.toJson(
                    graphElement
            ).put(
                    TYPES,
                    jsonAdditionalTypes(graphElement)
            ).put(
                    SAME_AS,
                    jsonSameAs(graphElement)
            ).put(
                    GENERIC_IDENTIFICATIONS,
                    genericIdentificationsJson(graphElement)
            );
        }catch(JSONException e){
            throw new RuntimeException(e);
        }
    }

    protected static JSONArray jsonAdditionalTypes(GraphElement graphElement) {
        JSONArray additionalTypes = new JSONArray();
        for (FriendlyResource friendlyResource : graphElement.getAdditionalTypes()) {
            additionalTypes.put(
                    FriendlyResourceJson.toJson(
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
                    FriendlyResourceJson.toJson(
                            friendlyResourceImpl
                    )
            );
        }
        return sameAs;
    }

    protected static JSONArray genericIdentificationsJson(GraphElement graphElement){
        JSONArray genericIdentifications = new JSONArray();
        for (FriendlyResource friendlyResourceImpl : graphElement.getGenericIdentifications()) {
            genericIdentifications.put(
                    FriendlyResourceJson.toJson(
                            friendlyResourceImpl
                    )
            );
        }
        return genericIdentifications;
    }

    protected static JSONObject toJsonAsIncludedGraphElement(GraphElement graphElement) {
        try {
            return new JSONObject().put(
                    LABEL,
                    graphElement.label()
            ).put(
                    URI,
                    graphElement.uri()
            );
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
