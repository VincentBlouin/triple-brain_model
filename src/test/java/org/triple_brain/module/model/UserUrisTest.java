package org.triple_brain.module.model;

import org.junit.Test;

import static junit.framework.Assert.assertTrue;

/*
* Copyright Mozilla Public License 1.1
*/
public class UserUrisTest {

    @Test
    public void generated_schema_uris_contains_schema(){
        UserUris userUris = new UserUris("pomme");
        assertTrue(
                userUris.generateSchemaUri().toString().contains("schema")
        );
    }
}
