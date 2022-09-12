package com.essexboy.helloworldapi;

import lombok.Getter;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Getter
@ToString
public class Config {

    final static Logger LOGGER = LoggerFactory.getLogger(Config.class);

    private String message = "hello world";
    private String downStreamUrl;

    public static Config getConfig() {
        Config config = new Config();
        if (System.getenv("HELLO_WORLD_MESSAGE") != null) {
            config.message = System.getenv("HELLO_WORLD_MESSAGE");
        }
        if (System.getenv("HELLO_WORLD_DOWN_STREAM_URL") != null) {
            config.downStreamUrl = System.getenv("HELLO_WORLD_DOWN_STREAM_URL");
        }
        LOGGER.debug("created {}", config);
        return config;
    }
}
