/*
 * Copyright Vincent Blouin under the Mozilla Public License 1.1
 */

package org.triple_brain.module.model;

import org.junit.Test;

import static junit.framework.Assert.assertTrue;

public class UserUrisTest {

    @Test
    public void generated_schema_uris_contains_schema(){
        UserUris userUris = new UserUris("pomme");
        assertTrue(
                userUris.generateSchemaUri().toString().contains("schema")
        );
    }
}
