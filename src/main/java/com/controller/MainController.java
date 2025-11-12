package com.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/*
 * MainController.java reponsible for handling incoming requests and delegating other classes to
 * handle the topics
 */
@RestController
public class MainController {
    private static final Logger LOG = LoggerFactory.getLogger(MainController.class);
    private static String NO_USER = "NO-USER";
    private String currentUser = "NO-USER";

    @GetMapping("/api/v1/name")
    public String microserviceName() {
        return "This microservice is the [SESSION-MANAGER]!";
    }

    @GetMapping("/api/v1/user")
    public String getUser() {
        System.out.println("\n");
        LOG.info("Received a request to grab the current logged in user... returning " + currentUser);
        return currentUser;
    }

    @PostMapping("/api/v1/logout")
    public void logout() {
        System.out.println("\n");
        LOG.info("Received a logout request...");
        currentUser = NO_USER;
    }
    
    @PostMapping("/api/v1/login")
    public void login(@RequestBody String user) {
        System.out.println("\n");
        LOG.info("Received a login request with user " + user + "...");
        currentUser = user;
    }
}
