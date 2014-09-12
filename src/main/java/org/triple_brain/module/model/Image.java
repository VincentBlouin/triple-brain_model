/*
 * Copyright Vincent Blouin under the Mozilla Public License 1.1
 */

package org.triple_brain.module.model;

import java.net.URI;
import java.util.UUID;

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
