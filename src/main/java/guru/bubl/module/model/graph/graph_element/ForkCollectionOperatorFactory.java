package guru.bubl.module.model.graph.graph_element;

import java.net.URI;
import java.util.Set;

public interface ForkCollectionOperatorFactory {
    ForkCollectionOperator withUris(Set<URI> uris);
}
