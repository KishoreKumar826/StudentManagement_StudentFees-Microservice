/**
 * This class is a REST controller for the Student Management System Client API.
 * It provides an endpoint to retrieve student information from the Student Management Service.
 **/
package com.example.demo;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import org.slf4j.Logger;

import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import reactor.core.publisher.Mono;
@RestController
public class StudentMSClientAPI {
private static final Logger LOGGER = LoggerFactory.getLogger(StudentMSClientAPI.class);

    @Autowired // load balanced
    private WebClient webClient;

    @GetMapping("/client-students")
   // @CircuitBreaker(name = "usermsclient", fallbackMethod = "usermsfallback")
    public Mono getStudentsFromStudentms() {
        LOGGER.info("About to call studentms from studentfeesms");
        return webClient.get().uri("/students").retrieve().bodyToMono(Object.class); 
    }

    // private Mono usermsfallback(CallNotPermittedException ex) {
    //     LOGGER.error("fallback invoked in open state");
    //     return Mono.just(new String[] {"a", "b", "c"});
    // }

}
