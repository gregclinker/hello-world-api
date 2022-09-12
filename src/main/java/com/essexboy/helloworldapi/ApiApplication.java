package com.essexboy.helloworldapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class ApiApplication {

    public static void main(String[] args) {

        SpringApplication app = new SpringApplication(ApiApplication.class);
        if (System.getenv("HELLO_WORLD_PORT") != null) {
            app.setDefaultProperties(Collections.singletonMap("server.port", System.getenv("HELLO_WORLD_PORT")));
        }
        app.run(args);
    }
}
