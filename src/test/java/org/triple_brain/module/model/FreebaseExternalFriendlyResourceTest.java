package org.triple_brain.module.model;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/*
* Copyright Mozilla Public License 1.1
*/
public class FreebaseExternalFriendlyResourceTest {

    @Test
    public void can_get_images(){
        ExternalFriendlyResource timBernersLee = ModelTestScenarios.timBernersLeeInFreebase();
        assertTrue(FreebaseExternalFriendlyResource.isFromFreebase(timBernersLee));
    }

}
