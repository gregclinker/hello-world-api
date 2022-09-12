package com.essexboy.helloworldapi;

import org.junit.jupiter.api.Test;
import org.junitpioneer.jupiter.SetEnvironmentVariable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ConfigTest {

    @Test
    @SetEnvironmentVariable(key = "HELLO_WORLD_MESSAGE", value = "helloworld")
    @SetEnvironmentVariable(key = "HELLO_WORLD_DOWN_STREAM_URL", value = "http://helloworld-service")
    void getConfig() {
        final Config config = Config.getConfig();
        assertNotNull(config);
        assertEquals("helloworld", config.getMessage());
        assertEquals("http://helloworld-service", config.getDownStreamUrl());
    }
}