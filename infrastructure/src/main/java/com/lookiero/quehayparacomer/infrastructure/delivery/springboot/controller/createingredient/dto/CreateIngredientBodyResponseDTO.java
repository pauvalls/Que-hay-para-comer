package com.lookiero.quehayparacomer.infrastructure.delivery.springboot.controller.createingredient.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateIngredientBodyResponseDTO {
    public String id;
    public String name;
    public NutricionalValuesDTO nutricionalValuesDTO;
}
