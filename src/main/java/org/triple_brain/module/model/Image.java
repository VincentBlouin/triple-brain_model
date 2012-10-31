package org.triple_brain.module.model;

import java.net.URL;

/*
* Copyright Mozilla Public License 1.1
*/
public class Image{
    URL urlForSmall;
    URL urlForBigger;

    public static Image withUrlForSmallAndBigger(URL urlForSmall, URL urlForBigger){
        return new Image(
                urlForSmall,
                urlForBigger
        );
    }

    public Image(URL urlForSmall, URL urlForBigger){
        this.urlForSmall = urlForSmall;
        this.urlForBigger = urlForBigger;
    }

    public URL urlForSmall(){
        return urlForSmall;
    }

    public URL urlForBigger(){
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
