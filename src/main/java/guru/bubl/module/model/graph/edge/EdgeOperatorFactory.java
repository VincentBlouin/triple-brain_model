package guru.bubl.module.model.graph.edge;

import java.net.URI;

public interface EdgeOperatorFactory {
    EdgeOperator withUri(URI uri);
}
