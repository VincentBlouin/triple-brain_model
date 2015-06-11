/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model;

import java.net.URI;

public class Image{

    String base64ForSmall;
    URI urlForBigger;

    public static Image withBase64ForSmallAndUriForBigger(String base64ForSmall, URI urlForBigger){
        return new Image(
                base64ForSmall,
                urlForBigger
        );
    }

    public Image(String base64ForSmall, URI urlForBigger){
        this.base64ForSmall = base64ForSmall;
        this.urlForBigger = urlForBigger;
    }

    public String base64ForSmall(){
        return base64ForSmall;
    }

    public URI urlForBigger(){
        return urlForBigger;
    }

    @Override
    public boolean equals(Object imageToCompareAsObject) {
        Image imageToCompare = (Image) imageToCompareAsObject;
        return urlForBigger().equals(imageToCompare.urlForBigger());
    }

    @Override
    public int hashCode() {
        return urlForBigger().hashCode();
    }
}
