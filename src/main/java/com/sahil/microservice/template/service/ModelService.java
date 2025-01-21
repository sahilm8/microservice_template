package com.sahil.microservice.template.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sahil.microservice.template.dto.addModel.AddModelRequest;
import com.sahil.microservice.template.dto.addModel.AddModelResponse;
import com.sahil.microservice.template.dto.deleteModel.DeleteModelRequest;
import com.sahil.microservice.template.dto.deleteModel.DeleteModelResponse;
import com.sahil.microservice.template.dto.getModel.GetModelRequest;
import com.sahil.microservice.template.dto.getModel.GetModelResponse;
import com.sahil.microservice.template.exception.ModelAlreadyExistsException;
import com.sahil.microservice.template.exception.ModelNotFoundException;
import com.sahil.microservice.template.model.Model;
import com.sahil.microservice.template.repository.ModelRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class ModelService {
    private final ModelRepository modelRepository;

    public AddModelResponse addModel(AddModelRequest addModelRequest) {
        if (!modelRepository.existsByName(addModelRequest.getName())) {
            Model model = Model.builder()
                    .name(addModelRequest.getName())
                    .description(addModelRequest.getDescription())
                    .build();
            Model savedModel = modelRepository.save(model);
            return AddModelResponse.builder().model(savedModel).build();
        }
        throw new ModelAlreadyExistsException("Model already exists");
    }

    public GetModelResponse getModel(GetModelRequest getModelRequest) {
        if (modelRepository.existsByName(getModelRequest.getName())) {
            Model model = modelRepository.findByName(getModelRequest.getName()).get();
            return GetModelResponse.builder().model(model).build();
        }
        throw new ModelNotFoundException("Model not found");
    }

    public DeleteModelResponse deleteModel(DeleteModelRequest deleteModelRequest) {
        if (modelRepository.existsByName(deleteModelRequest.getName())) {
            Model model = modelRepository.findByName(deleteModelRequest.getName()).get();
            modelRepository.delete(model);
            return DeleteModelResponse.builder().status("Model deleted successfully").build();
        }
        throw new ModelNotFoundException("Model not found");
    }
}
