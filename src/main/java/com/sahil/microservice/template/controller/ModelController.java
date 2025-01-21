package com.sahil.microservice.template.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sahil.microservice.template.dto.AddModelRequest;
import com.sahil.microservice.template.dto.AddModelResponse;
import com.sahil.microservice.template.dto.DeleteModelRequest;
import com.sahil.microservice.template.dto.DeleteModelResponse;
import com.sahil.microservice.template.dto.GetModelRequest;
import com.sahil.microservice.template.dto.GetModelResponse;
import com.sahil.microservice.template.service.ModelService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v2/model")
@RequiredArgsConstructor
@Validated
public class ModelController {
    private final ModelService modelService;

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> home() {
        return ResponseEntity.ok(String.format(
                "Microservice API Template%n%n" +
                        "Welcome to the /model endpoint, you can make the following requests:%n" +
                        "- POST /add-model%n" +
                        "- GET /get-model%n" +
                        "- DELETE /delete-model%n"));
    }

    @PostMapping(value = "/add-model", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AddModelResponse> addModel(@Valid @RequestBody AddModelRequest addModelRequest) {
        return ResponseEntity.ok(modelService.addModel(addModelRequest));
    }

    @GetMapping(value = "/get-model", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GetModelResponse> getModel(@Valid @RequestBody GetModelRequest getModelRequest) {
        return ResponseEntity.ok(modelService.getModel(getModelRequest));
    }

    @DeleteMapping(value = "/delete-model", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DeleteModelResponse> deleteModel(@Valid @RequestBody DeleteModelRequest deleteModelRequest) {
        return ResponseEntity.ok(modelService.deleteModel(deleteModelRequest));
    }

    @GetMapping(value = "/*", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> invalid() {
        return ResponseEntity
                .ok("Invalid request, please refer to the README at https://github.com/sahilm8/microservice_template");
    }
}
