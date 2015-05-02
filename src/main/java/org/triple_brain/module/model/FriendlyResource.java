/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package org.triple_brain.module.model;

import java.net.URI;
import java.util.Date;
import java.util.Set;

public interface FriendlyResource {
    URI uri();
    boolean hasLabel();
    String label();
    Set<Image> images();
    Boolean gotImages();
    String comment();
    Boolean gotComments();
    Date creationDate();
    Date lastModificationDate();
    String getOwnerUsername();
}

