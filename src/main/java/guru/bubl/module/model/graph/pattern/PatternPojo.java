package guru.bubl.module.model.graph.pattern;

import guru.bubl.module.model.graph.GraphElement;
import guru.bubl.module.model.graph.GraphElementPojo;

import java.net.URI;
import java.util.Map;

public class PatternPojo implements Pattern {

    private GraphElementPojo graphElement;
    private Map<URI, String> context;

    public PatternPojo(
            GraphElementPojo graphElement,
            Map<URI, String> context
    ) {
        this.graphElement = graphElement;
        this.context = context;
    }

    @Override
    public GraphElement getGraphElement() {
        return graphElement;
    }

    @Override
    public Map<URI, String> getContext() {
        return context;
    }

    @Override
    public int hashCode() {
        return graphElement.hashCode();
    }
}
