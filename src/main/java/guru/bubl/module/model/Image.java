/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model;

import java.net.URI;

public class Image {

    String urlForSmall;
    URI urlForBigger;

    public static Image withUrlForSmallAndUriForBigger(String urlForSmall, URI urlForBigger) {
        return new Image(
                urlForSmall,
                urlForBigger
        );
    }

    public Image(String urlForSmall, URI urlForBigger) {
        this.urlForSmall = urlForSmall;
        this.urlForBigger = urlForBigger;
    }

    public String urlForSmall() {
        return urlForSmall;
    }

    public URI urlForBigger() {
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
