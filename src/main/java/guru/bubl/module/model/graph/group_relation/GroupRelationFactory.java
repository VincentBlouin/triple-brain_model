package guru.bubl.module.model.graph.group_relation;

import com.google.inject.assistedinject.Assisted;
import guru.bubl.module.model.graph.edge.EdgeOperator;

import java.net.URI;

public interface GroupRelationFactory {
    GroupRelationOperator withUri(URI uri);
    GroupRelationOperator withUriAndTagUri(@Assisted("self") URI uri, @Assisted("tag") URI tagUri);
}
