package guru.bubl.module.model.graph.edge;

import guru.bubl.module.model.graph.ShareLevel;

import java.net.URI;

public interface EdgeOperator extends Edge{
    void changeSource(
            URI newSourceUri,
            ShareLevel oldEndShareLevel,
            ShareLevel keptEndShareLevel,
            ShareLevel newEndShareLevel
    );

    void changeDestination(
            URI newDestinationUri,
            ShareLevel oldEndShareLevel,
            ShareLevel keptEndShareLevel,
            ShareLevel newEndShareLevel
    );
}
