/*
 * Copyright Vincent Blouin under the GPL License version 3
 */

package guru.bubl.module.model;

import org.junit.Test;

import static junit.framework.Assert.assertTrue;

public class UserUrisTest {

    @Test
    public void generated_schema_uris_contains_schema(){
        UserUris userUris = new UserUris("user_name");
        assertTrue(
                userUris.generateSchemaUri().toString().contains("schema")
        );
    }

    @Test
    public void generate_tag_uri_has_service_prefix(){
        UserUris userUris = new UserUris("user_name");
        assertTrue(
                userUris.generateIdentificationUri().toString().contains("service")
        );
    }
}
