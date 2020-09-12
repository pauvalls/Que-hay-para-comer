package com.lookiero.quehayparacomer.infrastructure.delivery.springboot.controller.createingredient.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateIngredientBodyRequestDTO {
    public String name;
    public NutricionalValuesDTO nutricionalValuesDTO;
}
