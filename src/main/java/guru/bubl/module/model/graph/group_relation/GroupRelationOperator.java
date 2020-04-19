package guru.bubl.module.model.graph.group_relation;

import guru.bubl.module.model.graph.graph_element.GraphElementOperator;
import guru.bubl.module.model.graph.edge.EdgeOperator;
import guru.bubl.module.model.graph.fork.ForkOperator;

public interface GroupRelationOperator extends GroupRelation, GraphElementOperator, ForkOperator, EdgeOperator {
}
