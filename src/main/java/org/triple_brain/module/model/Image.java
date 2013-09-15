package org.triple_brain.module.model;

import java.net.URI;

/*
* Copyright Mozilla Public License 1.1
*/
public class Image{
    URI urlForSmall;
    URI urlForBigger;

    public static Image withUriForSmallAndBigger(URI urlForSmall, URI urlForBigger){
        return new Image(
                urlForSmall,
                urlForBigger
        );
    }

    public Image(URI urlForSmall, URI urlForBigger){
        this.urlForSmall = urlForSmall;
        this.urlForBigger = urlForBigger;
    }

    public URI urlForSmall(){
        return urlForSmall;
    }

    public URI urlForBigger(){
        return urlForBigger;
    }

    @Override
    public boolean equals(Object imageToCompareAsObject) {
        Image imageToCompare = (Image) imageToCompareAsObject;
        return urlForSmall().equals(imageToCompare.urlForSmall());
    }

    @Override
    public int hashCode() {
        return urlForSmall().hashCode();
    }
}
