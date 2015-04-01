/*
 * Copyright Vincent Blouin under the Mozilla Public License 1.1
 */

package org.triple_brain.module.model;

import org.apache.commons.lang.RandomStringUtils;

public class UserNameGeneratorImpl implements UserNameGenerator {

    private static final Integer NUMBER_OF_CHARS = 30;
    private UserNameGenerator override;

    @Override
    public String generate() {
        return override == null ?
                defaultGenerate() :
                override.generate();
    }

    @Override
    public void setOverride(UserNameGenerator userNameGenerator) {
        this.override = userNameGenerator;
    }

    @Override
    public void reset() {
        override = null;
    }

    private String defaultGenerate() {
        return RandomStringUtils.randomAlphanumeric(
                NUMBER_OF_CHARS
        );
    }
}
