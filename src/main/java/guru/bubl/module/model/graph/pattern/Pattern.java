package guru.bubl.module.model.graph.pattern;

import guru.bubl.module.model.graph.graph_element.GraphElement;

import java.net.URI;
import java.util.Map;

public interface Pattern {
    GraphElement getGraphElement();
    Map<URI, String> getContext();
}
