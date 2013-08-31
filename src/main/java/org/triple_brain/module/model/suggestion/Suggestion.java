package org.triple_brain.module.model.suggestion;

import org.triple_brain.module.model.FriendlyResource;

import java.util.Set;

/*
* Copyright Mozilla Public License 1.1
*/
public interface Suggestion extends FriendlyResource{

    public FriendlyResource sameAs();

    public FriendlyResource domain();

    public Set<SuggestionOrigin> origins();

    public void removeOriginsThatDependOnResource(FriendlyResource resource);

    public void remove();
}
