package com.template.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.template.microservice.model.Model;
import com.template.microservice.service.ModelService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("api/v1/model")
@Slf4j
public class ModelController {
    @Autowired
    private static ModelService modelService;

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public static String home() {
        log.info("Received request to GET /home.");
        return String.format(
                "Microservice Template%n%n" +
                        "Welcome to the model endpoint, you can make the following requests:%n" +
                        "- POST /new-model%n" +
                        "- GET /get-model%n" +
                        "- DELETE /delete-model%n");
    }

    @PostMapping(value = "/new-model", produces = MediaType.APPLICATION_JSON_VALUE)
    public static Model createModel(@RequestBody String name) {
        log.info("Received request to POST /new-model with argument: " + name);
        return modelService.createModel(name);
    }

    @GetMapping(value = "/get-model", produces = MediaType.APPLICATION_JSON_VALUE)
    public static Model getModel(@RequestBody String name) {
        log.info("Received request to GET /get-model with argument: " + name);
        return modelService.getModel(name);
    }

    @DeleteMapping(value = "/delete-model", produces = MediaType.APPLICATION_JSON_VALUE)
    public static Model deleteModel(@RequestBody String name) {
        log.info("Received request to DELETE /delete-model with argument: " + name);
        return modelService.getModel(name);
    }
}
