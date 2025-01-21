package com.sahil.microservice.template.dto.addModel;

import com.sahil.microservice.template.model.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddModelResponse {
    private Model model;
}
