package com.example.demo;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
/**
 * Configuration class for setting up the WebClient bean.
 * This class is responsible for creating and configuring the WebClient instance
 * that will be used for making HTTP requests to other services.
 */
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
@Configuration
public class WebClientconfig {
    @Bean // inject inside another class to call StudentMS
    @LoadBalanced // load balance the request
public WebClient.Builder builder() {
        return WebClient.builder().baseUrl("http://StudentMS"); // base url of userms to call StudentMS
    }

    @Bean // inject inside another class to call StudentMS
    public WebClient webClient(WebClient.Builder builder) {
        return builder.build();
    }

}
