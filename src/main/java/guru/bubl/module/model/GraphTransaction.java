/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model;

public interface GraphTransaction {
    public Object before();
    public void after(Object state);
}

