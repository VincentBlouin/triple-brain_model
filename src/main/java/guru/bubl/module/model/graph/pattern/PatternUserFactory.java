package guru.bubl.module.model.graph.pattern;

import guru.bubl.module.model.User;

import java.net.URI;

public interface PatternUserFactory {
    PatternUser forUserAndPatternUri(User user, URI patternUri);
}
