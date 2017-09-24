/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model.content;

import guru.bubl.module.model.FriendlyResource;
import guru.bubl.module.model.graph.subgraph.UserGraph;

import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public interface Content {
    default ResourceBundle getResourceBundle(){
        return PropertyResourceBundle.getBundle(
                this.getClass().getCanonicalName() + "ResourceBundle",
                getLocale()
        );
    }
    default Locale getLocale(){
            return getUserGraph().user().getLocaleForBundle();
    }
    FriendlyResource add();
    UserGraph getUserGraph();

}
