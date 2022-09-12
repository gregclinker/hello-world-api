package com.essexboy.helloworldapi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@RestController
public class Controller {

    @RequestMapping("/")
    public ResponseEntity<String> helloworld() throws URISyntaxException, IOException, InterruptedException {
        final Config config = Config.getConfig();
        final StringBuilder responseString = new StringBuilder();
        responseString.append(config.getMessage());
        if (config.getDownStreamUrl() != null) {
            HttpResponse<String> response = get(config.getDownStreamUrl());
            responseString.append(", downstream response from " + config.getDownStreamUrl() + "=" + response.body());
        }
        return new ResponseEntity<>(responseString.toString(), HttpStatus.OK);
    }

    public HttpResponse<String> get(String url) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url))
                .GET()
                .build();
        final HttpClient client = HttpClient.newBuilder().build();
        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }
}
