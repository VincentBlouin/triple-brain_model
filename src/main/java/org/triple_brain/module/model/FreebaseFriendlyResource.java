package org.triple_brain.module.model;

import com.google.api.client.http.*;
import com.google.api.client.http.javanet.NetHttpTransport;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.triple_brain.module.common_utils.DataFetcher;
import org.triple_brain.module.model.graph.FriendlyResourcePojo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

/*
* Copyright Mozilla Public License 1.1
*/
public class FreebaseFriendlyResource extends Observable {

    private FriendlyResourcePojo friendlyResource;

    public static String DESCRIPTION_BASE_URI = "https://www.googleapis.com/freebase/v1/text";

    public static Boolean isFromFreebase(FriendlyResource friendlyResource) {
        String host = friendlyResource.uri().getHost();
        if(host == null){
            return false;
        }
        return host.toLowerCase().
                        contains("freebase.com");
    }

    public static FreebaseFriendlyResource fromFriendlyResource(FriendlyResourcePojo friendlyResource) {
        return new FreebaseFriendlyResource(
                friendlyResource
        );
    }

    protected FreebaseFriendlyResource(FriendlyResourcePojo friendlyResource) {
        this.friendlyResource = friendlyResource;
    }

    public void getImages(Observer observer) {
        new Thread(new GetImageThread(
                this,
                observer
        )).start();
    }

    public void getDescription(Observer observer) {
        new Thread(new GetDescriptionThread(
                this,
                observer
        )).start();
    }

    public String freebaseId() {
        return friendlyResource.uri().toString()
                .replace("http://rdf.freebase.com/rdf", "");
    }

    public FriendlyResourcePojo getCachedFriendlyResource() {
        return friendlyResource;
    }

    private class GetImageThread implements Runnable{

        private FreebaseFriendlyResource freebaseFriendlyResource;
        private Observer observer;

        public GetImageThread(FreebaseFriendlyResource freebaseFriendlyResource, Observer observer){
            this.freebaseFriendlyResource = freebaseFriendlyResource;
            this.observer = observer;
        }

        @Override
        public void run() {
            observer.update(
                    freebaseFriendlyResource,
                    getImages()
            );
        }

        private Set<Image> getImages(){
            try{
                String imagesKey = "/common/topic/image";
                String id = "id";
                org.codehaus.jettison.json.JSONArray imagesQuery = new org.codehaus.jettison.json.JSONArray();
                imagesQuery.put(new org.codehaus.jettison.json.JSONObject().put(
                        id,
                        new org.codehaus.jettison.json.JSONArray()
                ));
                org.codehaus.jettison.json.JSONObject query = new org.codehaus.jettison.json.JSONObject();
                query.put(id, freebaseId());
                query.put(
                    imagesKey,
                    imagesQuery
                );
                HttpTransport httpTransport = new NetHttpTransport();
                HttpRequestFactory requestFactory = httpTransport.createRequestFactory();
                JSONParser parser = new JSONParser();
                GenericUrl url = new GenericUrl("https://www.googleapis.com/freebase/v1/mqlread");
                url.put("query", query.toString());
                url.put("key", "AIzaSyBHOqdqbswxnNmNb4k59ARSx-RWokLZhPA");
                url.put("raw", true);
                HttpRequest request = requestFactory.buildGetRequest(url);
                HttpResponse httpResponse = request.execute();
                JSONObject response = new JSONObject(parser.parse(httpResponse.parseAsString()).toString());
                Set<Image> images = new HashSet<>();
                if(response.getString("result").equals("null")){
                    return images;
                }
                JSONObject results = response.getJSONObject("result");
                JSONArray imagesAsJson = results.getJSONArray("/common/topic/image");
                for(int i = 0 ; i < imagesAsJson.length(); i++){
                    String imageId = imagesAsJson.getJSONObject(i).getJSONArray("id").getString(0);
                    String baseUrl = "https://www.googleapis.com/freebase/v1/image";
                    String key = "AIzaSyBHOqdqbswxnNmNb4k59ARSx-RWokLZhPA";
                    images.add(
                            Image.withUriForSmallAndBigger(
                                    URI.create(
                                            baseUrl + imageId + "?maxwidth=60&key=" + key
                                    ),
                                    URI.create(
                                            baseUrl + imageId + "?maxwidth=600&key=" + key
                                    )
                            )
                    );
                }
                return images;
            }catch(Exception e){
                throw new RuntimeException(e);
            }
        }
    }

    private class GetDescriptionThread implements Runnable{

        private FreebaseFriendlyResource freebaseFriendlyResource;
        private Observer observer;

        public GetDescriptionThread(FreebaseFriendlyResource freebaseFriendlyResource, Observer observer){
            this.freebaseFriendlyResource = freebaseFriendlyResource;
            this.observer = observer;
        }

        @Override
        public void run() {
            observer.update(
                    freebaseFriendlyResource,
                    getDescription()
            );
        }

       private String getDescription(){
            try{
                org.codehaus.jettison.json.JSONObject resultEnveloppe = DataFetcher.getJsonFromUrl(
                        new URL(
                                DESCRIPTION_BASE_URI +
                                        freebaseFriendlyResource.freebaseId() +
                                        "?key=AIzaSyBHOqdqbswxnNmNb4k59ARSx-RWokLZhPA"
                        )
                );
                return resultEnveloppe.getString("result");
            }catch(JSONException | MalformedURLException e){
                throw new RuntimeException(e);
            }
        }
    }
}
